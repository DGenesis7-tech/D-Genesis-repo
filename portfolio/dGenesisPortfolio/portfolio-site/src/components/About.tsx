export default function About() {
  return (
    <section className="border-y border-white/10 bg-zinc-900/50" id="about">
      <div className="mx-auto grid max-w-6xl gap-10 px-6 py-20 md:grid-cols-[0.7fr_1.3fr]">
        <div>
          <p className="text-sm font-semibold uppercase tracking-[0.2em] text-teal-300">
            About
          </p>
          <h2 className="mt-3 text-3xl font-bold text-white">
            From idea to launch, I bring product thinking and engineering discipline.
          </h2>
        </div>
        <div className="space-y-5 text-base leading-8 text-zinc-300">
          <p>
            I specialize in turning product ideas into secure, scalable, and
            user-friendly web applications. My background covers dashboards,
            marketplaces, payment flows, authentication, admin panels, and data
            driven interfaces across fintech, health-tech, agri-tech, and
            e-commerce.
          </p>
          <p>
            Whether you need an MVP, a redesign, or a dependable internal tool,
            I focus on clarity, speed, and long-term maintainability. Clients
            usually come to me when they want thoughtful execution without the
            usual agency friction.
          </p>
          <ul className="space-y-2 text-sm text-zinc-200">
            <li>• Full-stack builds for startups and growing teams</li>
            <li>• Clear product thinking with practical implementation</li>
            <li>• Calm delivery from discovery through launch</li>
          </ul>
        </div>
      </div>
    </section>
  );
}
