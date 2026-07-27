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
          <div className="grid gap-3 rounded-lg border border-teal-400/15 bg-teal-400/5 p-4 sm:grid-cols-3">
            {[
              { value: "10+", label: "product builds" },
              { value: "4+", label: "years of delivery" },
              { value: "100%", label: "remote collaboration" },
            ].map((stat) => (
              <div key={stat.label}>
                <p className="text-xl font-semibold text-white">{stat.value}</p>
                <p className="text-sm text-zinc-400">{stat.label}</p>
              </div>
            ))}
          </div>
        </div>
      </div>
    </section>
  );
}
