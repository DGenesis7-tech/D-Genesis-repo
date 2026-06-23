const skillGroups = [
  {
    title: "Frontend",
    skills: ["React.js", "Next.js", "TypeScript", "Tailwind CSS", "Bootstrap", "Responsive UI"],
  },
  {
    title: "Backend",
    skills: ["Java Spring Boot", "Node.js", "Express.js", "REST APIs", "Microservices", "JWT Auth"],
  },
  {
    title: "Data and delivery",
    skills: ["MongoDB", "PostgreSQL", "Firebase", "GitHub", "Postman", "Vercel", "Netlify"],
  },
];

export default function Skills() {
  return (
    <section className="mx-auto max-w-6xl px-6 py-20" id="skills">
      <div className="mb-10 max-w-2xl">
        <p className="text-sm font-semibold uppercase tracking-[0.2em] text-teal-300">
          Skills
        </p>
        <h2 className="mt-3 text-3xl font-bold text-white">
          Practical stack for client projects
        </h2>
      </div>
      <div className="grid gap-4 md:grid-cols-3">
        {skillGroups.map((group) => (
          <div
            className="rounded-lg border border-white/10 bg-zinc-900 p-6"
            key={group.title}
          >
            <h3 className="text-lg font-semibold text-white">{group.title}</h3>
            <div className="mt-5 flex flex-wrap gap-2">
              {group.skills.map((skill) => (
                <span
                  className="rounded-md bg-white/5 px-3 py-2 text-sm text-zinc-300"
                  key={skill}
                >
                  {skill}
                </span>
              ))}
            </div>
          </div>
        ))}
      </div>
    </section>
  );
}
