export default function About() {
  return (
    <section className="border-y border-white/10 bg-zinc-900/50" id="about">
      <div className="mx-auto grid max-w-6xl gap-10 px-6 py-20 md:grid-cols-[0.7fr_1.3fr]">
        <div>
          <p className="text-sm font-semibold uppercase tracking-[0.2em] text-teal-300">
            About
          </p>
          <h2 className="mt-3 text-3xl font-bold text-white">
            Reliable product engineering for serious founders and teams
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
            Clients get more than code. I bring clear communication, structured
            delivery, and calm problem-solving shaped by software training,
            engineering discipline, and hands-on hospitality leadership.
          </p>
        </div>
      </div>
    </section>
  );
}
