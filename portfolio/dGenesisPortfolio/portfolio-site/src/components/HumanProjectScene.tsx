import Image from "next/image";
import type { Project } from "@/data/projects";

type HumanProjectSceneProps = {
  type: Project["preview"];
  label?: string;
};

const sceneAssets: Record<Project["preview"], { src: string; alt: string }> = {
  finance: {
    src: "/assets/images/project-igosave.png",
    alt: "iGoSave secure savings dashboard with wallet cards and progress tracking",
  },
  marketplace: {
    src: "/assets/images/project-farmers-hub.png",
    alt: "Farmers Hub marketplace connecting farmer products, cart, orders, and inventory",
  },
  health: {
    src: "/assets/images/project-my-cycle.jpg",
    alt: "My Cycle private health tracker dashboard with cycle insights and privacy controls",
  },
  commerce: {
    src: "/assets/images/project-ecommerce.png",
    alt: "E-commerce store dashboard with product catalogue, checkout, payment, and inventory",
  },
  trading: {
    src: "/assets/images/project-forex-trading.png",
    alt: "Forex trading bot console with candlestick charts, trading signals, and broker API feeds",
  },
};

export default function HumanProjectScene({ type, label }: HumanProjectSceneProps) {
  const asset = sceneAssets[type];

  return (
    <div className="static-2d-scene" aria-label={label ?? asset.alt}>
      <Image
        className="static-2d-scene-image"
        src={asset.src}
        alt={asset.alt}
        fill
        sizes="(max-width: 768px) 100vw, 520px"
      />
    </div>
  );
}
