import type { Project } from "@/data/projects";
import HumanProjectScene from "./HumanProjectScene";

type ProjectPreviewProps = {
  type: Project["preview"];
};

const previewLabels: Record<Project["preview"], string> = {
  finance: "Savings dashboard",
  marketplace: "Marketplace flow",
  health: "Health insights",
  commerce: "Store admin",
  trading: "Trading console",
};

const previewDetails: Record<Project["preview"], { title: string; points: string[] }> = {
  finance: {
    title: "Goal savings flow",
    points: ["Secure login", "Deposits and withdrawals", "Progress tracking"],
  },
  marketplace: {
    title: "Farm-to-buyer marketplace",
    points: ["Product discovery", "Cart and orders", "Buyer/admin roles"],
  },
  health: {
    title: "Private health insights",
    points: ["Cycle prediction", "Calendar tracking", "Chart summaries"],
  },
  commerce: {
    title: "Online store operations",
    points: ["Catalogue filtering", "Secure checkout", "Inventory control"],
  },
  trading: {
    title: "Automated trading console",
    points: ["Broker feeds", "Signal rules", "Risk controls"],
  },
};

export default function ProjectPreview({ type }: ProjectPreviewProps) {
  const detail = previewDetails[type];

  return (
    <div className={`project-preview project-preview-${type}`}>
      <div className="preview-topbar">
        <span />
        <span />
        <span />
        <p>{previewLabels[type]}</p>
      </div>
      <HumanProjectScene type={type} />
      <div className="project-preview-explainer">
        <strong>{detail.title}</strong>
        <div className="mt-2 flex flex-wrap gap-2">
          {detail.points.map((point) => (
            <span
              className="rounded-full border border-teal-400/20 bg-teal-400/10 px-2.5 py-1 text-[11px] font-medium text-teal-100"
              key={point}
            >
              {point}
            </span>
          ))}
        </div>
      </div>
    </div>
  );
}
