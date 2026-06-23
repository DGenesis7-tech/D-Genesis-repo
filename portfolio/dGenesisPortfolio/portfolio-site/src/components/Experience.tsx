const experience = [
  {
    role: "Full-stack software engineering",
    detail:
      "Postgraduate Diploma in Full-Stack Software Engineering at Semicolon Africa x Henley Business School, with project work spanning Java Spring Boot, React, Node.js, databases, and deployment workflows.",
  },
  {
    role: "Engineering foundation",
    detail:
      "B.Sc. Mechanical Engineering from Federal University Oye-Ekiti, strengthening analytical thinking, systems design, and disciplined problem solving.",
  },
  {
    role: "Client communication and leadership",
    detail:
      "Three years of hospitality leadership in Lagos venues, building composure under pressure, clear communication, and service-minded delivery.",
  },
];

export default function Experience() {
  return (
    <section className="mx-auto max-w-6xl px-6 py-20" id="experience">
      <div className="mb-10 max-w-2xl">
        <p className="text-sm font-semibold uppercase tracking-[0.2em] text-teal-300">
          Experience
        </p>
        <h2 className="mt-3 text-3xl font-bold text-white">
          Training, discipline, and client-ready communication
        </h2>
      </div>
      <div className="space-y-4">
        {experience.map((item) => (
          <div
            className="grid gap-3 rounded-lg border border-white/10 bg-zinc-900 p-6 md:grid-cols-[0.45fr_1fr]"
            key={item.role}
          >
            <h3 className="font-semibold text-white">{item.role}</h3>
            <p className="leading-7 text-zinc-300">{item.detail}</p>
          </div>
        ))}
      </div>
    </section>
  );
}
