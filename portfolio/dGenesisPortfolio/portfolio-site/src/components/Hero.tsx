import Link from "next/link";
import Image from "next/image";
import GenesisLogo from "./GenesisLogo";

const proofPoints = ["MVPs & SaaS", "Secure auth", "Fast iteration", "Remote delivery"];

export default function Hero() {
  return (
    <section
      className="mx-auto grid min-h-[calc(100vh-73px)] max-w-6xl items-center gap-10 px-6 py-20 lg:grid-cols-[1.15fr_0.85fr]"
      id="home"
    >
      <div>
        <GenesisLogo />
        <p className="mb-4 text-sm font-semibold uppercase tracking-[0.2em] text-teal-300">
          Genesis Inc — product engineering for founders who need momentum
        </p>
        <h1 className="max-w-3xl text-5xl font-bold leading-tight text-white md:text-7xl">
          I build modern web products that feel sharp, work reliably, and ship with purpose.
        </h1>
        <p className="mt-6 max-w-2xl text-lg leading-8 text-zinc-300">
          I help startups and teams turn ideas into clear, scalable experiences — from MVPs and dashboards to marketplace flows, APIs, and polished frontend systems.
        </p>
        <div className="mt-8 grid max-w-2xl grid-cols-2 gap-3 sm:grid-cols-4">
          {proofPoints.map((item) => (
            <div
              className="rounded-lg border border-white/10 bg-white/5 px-4 py-3 text-sm font-semibold text-white"
              key={item}
            >
              {item}
            </div>
          ))}
        </div>
        <div className="mt-8 flex flex-wrap gap-3">
          <a
            className="rounded-md bg-teal-400 px-5 py-3 text-sm font-semibold text-zinc-950 transition hover:bg-teal-300"
            href="mailto:danielokp328@gmail.com?subject=Project%20Inquiry%20for%20Daniel%20Genesis"
          >
            Book a discovery call
          </a>
          <Link
            className="rounded-md border border-white/15 px-5 py-3 text-sm font-semibold text-white transition hover:border-teal-300 hover:text-teal-300"
            href="/prototypes/igosave"
          >
            Explore a live prototype
          </Link>
        </div>
      </div>
      <div className="hero-console relative min-h-[420px] overflow-hidden rounded-lg border border-white/10 bg-zinc-900">
        <Image
          className="hero-2d-image"
          src="/assets/images/hero-developer-ai.png"
          alt="Daniel Genesis full-stack developer hero illustration with humanoid software assistant"
          fill
          priority
          sizes="(max-width: 1024px) 100vw, 520px"
        />
      </div>
    </section>
  );
}
