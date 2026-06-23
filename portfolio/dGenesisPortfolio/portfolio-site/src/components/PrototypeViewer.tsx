"use client";

import Link from "next/link";
import { useState } from "react";
import type { Prototype } from "@/data/prototypes";

type PrototypeViewerProps = {
  prototype: Prototype;
};

export default function PrototypeViewer({ prototype }: PrototypeViewerProps) {
  const [activeStep, setActiveStep] = useState(0);
  const step = prototype.steps[activeStep];

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
              <div className="prototype-main-card">
                <p>{step.title}</p>
                <strong>{step.action}</strong>
                <span />
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
