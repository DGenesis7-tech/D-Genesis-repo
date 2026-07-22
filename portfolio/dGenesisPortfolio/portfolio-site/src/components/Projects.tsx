import { projects } from "@/data/projects";
import ProjectPreview from "./ProjectPreview";

export default function Projects() {
  return (
    <section className="border-y border-white/10 bg-zinc-900/50" id="projects">
      <div className="mx-auto max-w-6xl px-6 py-20">
        <div className="mb-10 max-w-3xl">
          <p className="text-sm font-semibold uppercase tracking-[0.2em] text-teal-300">
            Case studies
          </p>
          <h2 className="mt-3 text-3xl font-bold text-white">
            Real applications across business-critical domains
          </h2>
        </div>
        <div className="grid gap-4 md:grid-cols-2">
          {projects.map((project) => (
            <article
              className="group flex min-h-[520px] flex-col overflow-hidden rounded-lg border border-white/10 bg-zinc-950/95"
              key={project.title}
            >
              <ProjectPreview type={project.preview} />
              <div className="flex flex-1 flex-col p-6">
                <h3 className="text-xl font-semibold text-white">{project.title}</h3>
                <p className="mt-4 flex-1 leading-7 text-zinc-300">
                  {project.description}
                </p>
                <ul className="mt-5 space-y-2 text-sm text-zinc-300">
                  {project.highlights.map((highlight) => (
                    <li className="flex gap-2" key={highlight}>
                      <span className="mt-2 h-1.5 w-1.5 shrink-0 rounded-full bg-teal-300" />
                      <span>{highlight}</span>
                    </li>
                  ))}
                </ul>
                <div className="mt-5 flex flex-wrap gap-2">
                  {project.stack.map((item) => (
                    <span
                      className="rounded-md bg-teal-400/10 px-3 py-1 text-xs font-medium text-teal-200"
                      key={item}
                    >
                      {item}
                    </span>
                  ))}
                </div>
                <a
                  className="mt-6 rounded-md bg-teal-400 px-4 py-3 text-center text-sm font-semibold text-zinc-950 transition hover:bg-teal-300"
                  href={project.prototypeHref}
                >
                  Open browser prototype
                </a>
                {(project.designLinks.canva || project.designLinks.figma) && (
                  <div className="mt-3 grid grid-cols-2 gap-2">
                    {project.designLinks.canva && (
                      <a
                        className="rounded-md border border-teal-300/50 px-3 py-2 text-center text-xs font-semibold text-teal-200 transition hover:bg-teal-300/10"
                        href={project.designLinks.canva}
                        rel="noreferrer"
                        target="_blank"
                      >
                        Canva preview
                      </a>
                    )}
                    {project.designLinks.figma && (
                      <a
                        className="rounded-md border border-teal-300/50 px-3 py-2 text-center text-xs font-semibold text-teal-200 transition hover:bg-teal-300/10"
                        href={project.designLinks.figma}
                        rel="noreferrer"
                        target="_blank"
                      >
                        Figma preview
                      </a>
                    )}
                  </div>
                )}
                <a
                  className="mt-3 text-center text-sm font-semibold text-teal-300 transition hover:text-teal-200"
                  href={project.href}
                >
                  Discuss a similar project
                </a>
              </div>
            </article>
          ))}
        </div>
      </div>
    </section>
  );
}
