export default function Footer() {
  return (
    <footer className="border-t border-white/10 px-6 py-8">
      <div className="mx-auto flex max-w-6xl flex-col gap-3 text-sm text-zinc-400 md:flex-row md:items-center md:justify-between">
        <p>
          &copy; {new Date().getFullYear()} Daniel Genesis. Product engineering for founders and teams.
        </p>
        <div className="flex items-center gap-4">
          <a className="transition hover:text-teal-300" href="#home">
            Back to top
          </a>
          <a className="transition hover:text-teal-300" href="#contact">
            Contact
          </a>
        </div>
      </div>
    </footer>
  );
}
