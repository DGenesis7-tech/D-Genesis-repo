export type Project = {
  slug: string;
  title: string;
  description: string;
  highlights: string[];
  preview: "finance" | "marketplace" | "health" | "commerce" | "trading";
  prototypeHref: string;
  designLinks: {
    canva?: string;
    figma?: string;
  };
  stack: string[];
  href: string;
};

export const projects: Project[] = [
  {
    slug: "igosave",
    title: "iGoSave - Personal Savings App",
    description:
      "A fintech savings platform with secure user accounts, savings goals, deposits, withdrawals, and real-time progress dashboards.",
    highlights: ["RESTful account and savings APIs", "JWT auth with bcrypt hashing", "Interactive progress dashboard"],
    preview: "finance",
    prototypeHref: "/prototypes/igosave",
    designLinks: {},
    stack: ["Java Spring Boot", "React.js", "MongoDB", "JWT Auth"],
    href: "#contact",
  },
  {
    slug: "farmers-hub",
    title: "Farmers Hub - Agri-Tech Marketplace",
    description:
      "A marketplace connecting farmers, buyers, and admins with product listings, search, cart, and order management.",
    highlights: ["Dual-role platform flows", "Product search and cart", "Mobile-first interface"],
    preview: "marketplace",
    prototypeHref: "/prototypes/farmers-hub",
    designLinks: {},
    stack: ["React.js", "Node.js", "Express.js", "MongoDB"],
    href: "#contact",
  },
  {
    slug: "my-cycle",
    title: "My Cycle - Health Tracker",
    description:
      "A privacy-conscious women's health app for cycle tracking, ovulation prediction, and accessible health data visualization.",
    highlights: ["Prediction logic", "Chart.js insights", "Encrypted account flow"],
    preview: "health",
    prototypeHref: "/prototypes/my-cycle",
    designLinks: {},
    stack: ["React.js", "Node.js", "MongoDB", "Chart.js"],
    href: "#contact",
  },
  {
    slug: "e-commerce-store",
    title: "E-Commerce Online Store",
    description:
      "A full-stack shopping platform with product catalogue, filtering, secure payments, and admin inventory workflows.",
    highlights: ["Stripe payment integration", "Admin order management", "Search and filtering"],
    preview: "commerce",
    prototypeHref: "/prototypes/e-commerce-store",
    designLinks: {},
    stack: ["React.js", "Node.js", "Express.js", "Stripe API"],
    href: "#contact",
  },
  {
    slug: "forex-trading-bot",
    title: "Forex Trading Bot",
    description:
      "An automated trading system integrating broker APIs, real-time price feeds, strategy rules, and risk controls.",
    highlights: ["Broker API integration", "RSI and moving average signals", "Stop-loss and position sizing"],
    preview: "trading",
    prototypeHref: "/prototypes/forex-trading-bot",
    designLinks: {},
    stack: ["Python", "Algorithmic Trading", "Broker APIs"],
    href: "#contact",
  },
];
