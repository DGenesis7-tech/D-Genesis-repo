import GenesisLogo from "./GenesisLogo";

const navItems = [
  { label: "About", href: "#about" },
  { label: "Services", href: "#services" },
  { label: "Skills", href: "#skills" },
  { label: "Projects", href: "#projects" },
  { label: "Experience", href: "#experience" },
  { label: "Contact", href: "#contact" },
];

export default function Navbar() {
  return (
    <header className="sticky top-0 z-50 border-b border-white/10 bg-zinc-950/85 backdrop-blur">
      <nav className="mx-auto flex max-w-6xl items-center justify-between px-6 py-4">
        <a className="text-sm font-semibold tracking-wide text-white" href="#home">
          <GenesisLogo />
        </a>
        <div className="hidden items-center gap-6 text-sm text-zinc-300 md:flex">
          {navItems.map((item) => (
            <a
              className="transition hover:text-teal-300"
              href={item.href}
              key={item.href}
            >
              {item.label}
            </a>
          ))}
        </div>
        <a
          className="rounded-md bg-teal-400 px-4 py-2 text-sm font-semibold text-zinc-950 transition hover:bg-teal-300"
          href="mailto:danielokp328@gmail.com?subject=Project%20Inquiry%20for%20Daniel%20Genesis"
        >
          Hire me
        </a>
      </nav>
    </header>
  );
}
