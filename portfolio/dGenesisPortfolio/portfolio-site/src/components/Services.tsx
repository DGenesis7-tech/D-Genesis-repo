import Image from "next/image";

const services = [
  {
    title: "MVPs and product builds",
    image: "/assets/images/service-backend-api.png",
    alt: "Backend API architecture with servers, REST routes, databases, and cloud deployment",
    description:
      "From discovery to launch, I turn ideas into working experiences with thoughtful UX, strong architecture, and fast iteration.",
  },
  {
    title: "Modern frontend experiences",
    image: "/assets/images/service-frontend-ui.png",
    alt: "Frontend UI work across desktop, tablet, and mobile screens",
    description:
      "Responsive dashboards, customer-facing products, and polished interfaces that are clear, trustworthy, and easy to use.",
  },
  {
    title: "Secure backends and integrations",
    image: "/assets/images/service-database-auth.png",
    alt: "Secure database and authentication system with roles and encrypted flows",
    description:
      "APIs, auth flows, payment logic, admin tools, and third-party integrations built for reliability and maintainability.",
  },
  {
    title: "Prototype to production support",
    image: "/assets/images/service-prototype-design.png",
    alt: "Product prototype and design workflow with wireframes, feedback, and user flow panels",
    description:
      "Quick prototypes and product flows that help teams validate direction before scaling into a full build.",
  },
] as const;

export default function Services() {
  return (
    <section className="mx-auto max-w-6xl px-6 py-20" id="services">
      <div className="mb-10 max-w-2xl">
        <p className="text-sm font-semibold uppercase tracking-[0.2em] text-teal-300">
          Services
        </p>
        <h2 className="mt-3 text-3xl font-bold text-white">
          Where I create the most value
        </h2>
      </div>
      <div className="grid gap-4 md:grid-cols-2">
        {services.map((service) => (
          <article
            className="group overflow-hidden rounded-lg border border-white/10 bg-zinc-900/90 transition hover:border-teal-300/40 hover:shadow-2xl hover:shadow-teal-500/20"
            key={service.title}
          >
            <div className="service-visual">
              <Image
                className="service-visual-image"
                src={service.image}
                alt={service.alt}
                fill
                sizes="(max-width: 768px) 100vw, 560px"
              />
            </div>
            <div className="p-6">
              <h3 className="text-lg font-semibold text-white">{service.title}</h3>
              <p className="mt-4 leading-7 text-zinc-300">{service.description}</p>
            </div>
          </article>
        ))}
      </div>
    </section>
  );
}
