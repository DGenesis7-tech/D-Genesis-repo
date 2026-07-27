const contactLinks = [
  { label: "Email Daniel", href: "mailto:danielokp328@gmail.com?subject=Project%20Inquiry%20for%20Daniel%20Genesis" },
  { label: "GitHub", href: "https://github.com/DGenesis7-tech" },
  { label: "LinkedIn", href: "https://www.linkedin.com/in/DanielGenesis" },
  { label: "Live Portfolio", href: "https://dgenesis7-tech.github.io/D-Genesis-repo/" },
];

export default function Contact() {
  return (
    <section className="border-t border-white/10 bg-zinc-900/50" id="contact">
      <div className="mx-auto grid max-w-6xl gap-8 px-6 py-20 md:grid-cols-[1fr_0.8fr]">
        <div>
          <p className="text-sm font-semibold uppercase tracking-[0.2em] text-teal-300">
            Contact
          </p>
          <h2 className="mt-3 text-3xl font-bold text-white">
            Ready to build something useful and well-crafted?
          </h2>
          <p className="mt-5 max-w-2xl leading-8 text-zinc-300">
            Share your idea, timeline, and goals. I can help you shape the right
            path forward, whether that means a quick prototype, a polished MVP,
            or a full product build.
          </p>
          <p className="mt-5 text-sm font-semibold text-teal-300">
            Based in Lagos, Nigeria. Available for remote freelance work and product partnerships.
          </p>
        </div>
        <div className="flex flex-col justify-center gap-3">
          <div className="rounded-lg border border-teal-400/15 bg-teal-400/5 p-4 text-sm text-zinc-300">
            Best for: MVPs, dashboards, marketplaces, API systems, and redesigns.
          </div>
          {contactLinks.map((link) => (
            <a
              className="rounded-lg border border-white/10 bg-zinc-950 px-5 py-4 font-semibold text-white transition hover:border-teal-300 hover:text-teal-300"
              href={link.href}
              key={link.label}
              rel="noreferrer"
              target={link.href.startsWith("http") ? "_blank" : undefined}
            >
              {link.label}
            </a>
          ))}
        </div>
      </div>
    </section>
  );
}
