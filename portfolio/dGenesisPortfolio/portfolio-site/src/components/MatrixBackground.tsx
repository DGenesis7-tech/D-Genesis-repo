const drops = Array.from({ length: 220 }, (_, index) => ({
  id: index,
  value: index % 3 === 0 ? "1" : "0",
  left: `${(index * 37) % 100}%`,
  delay: `${-((index * 0.37) % 16)}s`,
  duration: `${5 + (index % 11) * 0.55}s`,
  size: `${10 + (index % 5) * 3}px`,
  opacity: `${0.24 + (index % 7) * 0.08}`,
}));

export default function MatrixBackground() {
  return (
    <div
      aria-hidden="true"
      className="pointer-events-none fixed inset-0 z-0 overflow-hidden opacity-40"
    >
      <div className="absolute inset-0 bg-[radial-gradient(circle_at_top_left,rgba(20,184,166,0.18),transparent_34%),linear-gradient(180deg,rgba(9,9,11,0.35),#09090b_92%)]" />
      <div className="absolute inset-0">
        {drops.map((drop) => (
          <span
            className="matrix-drop absolute top-0 font-mono font-semibold text-teal-300"
            key={drop.id}
            style={
              {
                "--delay": drop.delay,
                "--duration": drop.duration,
                "--drop-opacity": drop.opacity,
                fontSize: drop.size,
                left: drop.left,
              } as React.CSSProperties
            }
          >
            {drop.value}
          </span>
        ))}
      </div>
      <div className="absolute inset-0 bg-[linear-gradient(90deg,#09090b_0%,transparent_22%,transparent_78%,#09090b_100%)]" />
    </div>
  );
}
