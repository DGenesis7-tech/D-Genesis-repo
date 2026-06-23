import Image from "next/image";

const services = [
  {
    title: "Backend APIs and cloud-ready systems",
    image: "/assets/images/service-backend-api.png",
    alt: "Backend API architecture with servers, REST routes, databases, and cloud deployment",
    description:
      "Java Spring Boot or Node.js APIs with clean data models, REST routes, cloud-ready structure, and deployment discipline.",
  },
  {
    title: "Frontend UI and responsive dashboards",
    image: "/assets/images/service-frontend-ui.png",
    alt: "Frontend UI work across desktop, tablet, and mobile screens",
    description:
      "Modern React and Next.js interfaces that improve clarity, mobile usability, component structure, and client trust.",
  },
  {
    title: "Database, auth, and role-based access",
    image: "/assets/images/service-database-auth.png",
    alt: "Secure database and authentication system with roles and encrypted flows",
    description:
      "Secure user accounts, JWT-style flows, admin/user roles, encrypted data patterns, and reliable database design.",
  },
  {
    title: "Prototype and product design support",
    image: "/assets/images/service-prototype-design.png",
    alt: "Product prototype and design workflow with wireframes, feedback, and user flow panels",
    description:
      "Clickable prototypes, user-flow thinking, feature planning, and polished product screens before full implementation.",
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
          What I can help you ship
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
