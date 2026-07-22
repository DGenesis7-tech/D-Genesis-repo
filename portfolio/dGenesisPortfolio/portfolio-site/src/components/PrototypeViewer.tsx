"use client";

import Link from "next/link";
import { useEffect, useRef, useState } from "react";
import type { Prototype } from "@/data/prototypes";

type PrototypeViewerProps = {
  prototype: Prototype;
};

function drawPreview(context: CanvasRenderingContext2D, width: number, height: number, step: Prototype["steps"][0]) {
  const radius = 20;
  const padding = 24;
  context.clearRect(0, 0, width, height);

  const gradient = context.createLinearGradient(0, 0, width, height);
  gradient.addColorStop(0, "#081018");
  gradient.addColorStop(1, "#111d36");
  context.fillStyle = gradient;
  context.fillRect(0, 0, width, height);

  context.save();
  context.fillStyle = "rgba(255, 255, 255, 0.05)";
  context.beginPath();
  context.moveTo(padding + radius, padding);
  context.lineTo(width - padding - radius, padding);
  context.quadraticCurveTo(width - padding, padding, width - padding, padding + radius);
  context.lineTo(width - padding, height - padding - radius);
  context.quadraticCurveTo(width - padding, height - padding, width - padding - radius, height - padding);
  context.lineTo(padding + radius, height - padding);
  context.quadraticCurveTo(padding, height - padding, padding, height - padding - radius);
  context.lineTo(padding, padding + radius);
  context.quadraticCurveTo(padding, padding, padding + radius, padding);
  context.closePath();
  context.fill();
  context.restore();

  context.fillStyle = "rgba(45, 212, 191, 0.2)";
  context.fillRect(padding + 20, padding + 20, 96, 5);

  context.fillStyle = "#e2e8f0";
  context.font = "700 24px Inter, sans-serif";
  context.fillText(step.title, padding + 20, padding + 60, width - padding * 2 - 40);

  const actionText = step.action.toUpperCase();
  context.font = "700 12px Inter, sans-serif";
  const pillWidth = Math.min(width - padding * 2 - 40, context.measureText(actionText).width + 34);
  context.fillStyle = "rgba(45, 212, 191, 0.14)";
  context.fillRect(padding + 20, padding + 90, pillWidth, 28);
  context.fillStyle = "#2dd4bf";
  context.fillText(actionText, padding + 28, padding + 110);

  context.fillStyle = "#94a3b8";
  context.font = "400 14px Inter, sans-serif";
  const lines = [];
  let text = step.description;
  while (text.length > 0) {
    const fit = text.slice(0, 40);
    const lastSpace = fit.lastIndexOf(" ");
    const line = text.length <= 40 ? text : fit.slice(0, lastSpace > 0 ? lastSpace : 40);
    lines.push(line);
    text = text.slice(line.length).trim();
  }
  lines.slice(0, 4).forEach((line, index) => {
    context.fillText(line, padding + 20, padding + 150 + index * 22);
  });

  context.lineWidth = 1;
  context.strokeStyle = "rgba(45, 212, 191, 0.12)";
  context.stroke();
}

export default function PrototypeViewer({ prototype }: PrototypeViewerProps) {
  const [activeStep, setActiveStep] = useState(0);
  const canvasRef = useRef<HTMLCanvasElement | null>(null);
  const step = prototype.steps[activeStep];

  useEffect(() => {
    const canvas = canvasRef.current;
    if (!canvas) return;

    const context = canvas.getContext("2d");
    if (!context) return;

    const dpr = window.devicePixelRatio || 1;
    const rect = canvas.getBoundingClientRect();

    canvas.width = rect.width * dpr;
    canvas.height = rect.height * dpr;
    context.setTransform(dpr, 0, 0, dpr, 0, 0);

    drawPreview(context, rect.width, rect.height, step);
  }, [step]);

  return (
    <div className={`prototype-shell prototype-${prototype.accent}`}>
      <aside className="prototype-sidebar">
        <Link className="prototype-back" href="/#projects">
          Back to portfolio
        </Link>
        <p className="prototype-eyebrow">Interactive prototype</p>
        <h1>{prototype.title}</h1>
        <p>{prototype.tagline}</p>
        <div className="prototype-meta">
          <span>Audience</span>
          <strong>{prototype.audience}</strong>
        </div>
        <div className="prototype-meta">
          <span>Outcome</span>
          <strong>{prototype.outcome}</strong>
        </div>
      </aside>

      <main className="prototype-stage">
        <div className="prototype-device">
          <div className="prototype-device-top">
            <span />
            <span />
            <span />
            <p>{step.action}</p>
          </div>
          <div className="prototype-screen">
            <div className="prototype-screen-header">
              <span>{prototype.title}</span>
              <strong>Step {activeStep + 1}/3</strong>
            </div>
            <div className="prototype-visual">
              <div className="prototype-canvas">
                <canvas ref={canvasRef} aria-label={`Prototype preview for ${step.title}`} />
              </div>
              <div className="prototype-side-stack">
                <span />
                <span />
                <span />
              </div>
            </div>
            <p className="prototype-description">{step.description}</p>
          </div>
        </div>

        <div className="prototype-controls" aria-label="Prototype steps">
          {prototype.steps.map((item, index) => (
            <button
              className={index === activeStep ? "active" : ""}
              key={item.title}
              onClick={() => setActiveStep(index)}
              type="button"
            >
              <span>{index + 1}</span>
              {item.title}
            </button>
          ))}
        </div>
      </main>
    </div>
  );
}
