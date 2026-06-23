import { notFound } from "next/navigation";
import PrototypeViewer from "@/components/PrototypeViewer";
import { getPrototype, prototypes } from "@/data/prototypes";

export function generateStaticParams() {
  return prototypes.map((prototype) => ({
    slug: prototype.slug,
  }));
}

export async function generateMetadata({
  params,
}: {
  params: Promise<{ slug: string }>;
}) {
  const { slug } = await params;
  const prototype = getPrototype(slug);

  if (!prototype) {
    return {
      title: "Prototype not found",
    };
  }

  return {
    title: `${prototype.title} | Daniel Genesis`,
    description: prototype.tagline,
  };
}

export default async function PrototypePage({
  params,
}: {
  params: Promise<{ slug: string }>;
}) {
  const { slug } = await params;
  const prototype = getPrototype(slug);

  if (!prototype) {
    notFound();
  }

  return <PrototypeViewer prototype={prototype} />;
}
