import { projects } from "./projects";

export type PrototypeStep = {
  title: string;
  description: string;
  action: string;
};

export type Prototype = {
  slug: string;
  title: string;
  tagline: string;
  audience: string;
  outcome: string;
  accent: string;
  steps: PrototypeStep[];
};

export const prototypes: Prototype[] = [
  {
    slug: "igosave",
    title: "iGoSave Savings Flow",
    tagline: "A secure journey from account creation to goal tracking.",
    audience: "Fintech founders, savings cooperatives, and personal finance teams",
    outcome: "Users can create goals, fund savings, and monitor progress in real time.",
    accent: "teal",
    steps: [
      {
        title: "Create secure account",
        description:
          "The user signs up, verifies details, and enters a protected dashboard backed by JWT authentication.",
        action: "Authenticate",
      },
      {
        title: "Set savings goal",
        description:
          "The app guides users to name a target, set an amount, choose a deadline, and track the plan.",
        action: "Create goal",
      },
      {
        title: "Monitor progress",
        description:
          "Deposits and withdrawals update dashboards so the user always understands the next action.",
        action: "View dashboard",
      },
    ],
  },
  {
    slug: "farmers-hub",
    title: "Farmers Hub Marketplace Flow",
    tagline: "A buyer-friendly path from farm products to confirmed orders.",
    audience: "Agri-tech startups, food distributors, and local marketplace teams",
    outcome: "Farmers list products while buyers search, compare, cart, and order.",
    accent: "lime",
    steps: [
      {
        title: "Browse produce",
        description:
          "Buyers scan fresh product cards with pricing, location, quantity, and availability signals.",
        action: "Search products",
      },
      {
        title: "Add to cart",
        description:
          "The cart flow keeps order quantity, delivery details, and farmer information visible.",
        action: "Build cart",
      },
      {
        title: "Manage orders",
        description:
          "Farmers and admins can review listings, orders, fulfillment status, and buyer activity.",
        action: "Open admin",
      },
    ],
  },
  {
    slug: "my-cycle",
    title: "My Cycle Health Flow",
    tagline: "A private, calm health tracker for cycle and ovulation insights.",
    audience: "Health-tech founders and wellness product teams",
    outcome: "Users log cycle data and receive clear, privacy-aware predictions.",
    accent: "rose",
    steps: [
      {
        title: "Log cycle data",
        description:
          "The interface keeps sensitive inputs simple, readable, and respectful of privacy.",
        action: "Add entry",
      },
      {
        title: "Predict window",
        description:
          "Prediction logic estimates upcoming cycle and ovulation windows from user history.",
        action: "Analyze",
      },
      {
        title: "Visualize insights",
        description:
          "Charts make trends easier to understand without overwhelming the user.",
        action: "View insights",
      },
    ],
  },
  {
    slug: "e-commerce-store",
    title: "E-Commerce Store Flow",
    tagline: "A fast purchase path with catalogue, payments, and admin control.",
    audience: "Retail brands, online stores, and product-led businesses",
    outcome: "Customers can browse, filter, pay, while admins manage stock and orders.",
    accent: "sky",
    steps: [
      {
        title: "Find products",
        description:
          "Customers search and filter products from a catalogue designed for fast comparison.",
        action: "Filter catalogue",
      },
      {
        title: "Checkout securely",
        description:
          "A focused checkout pattern prepares the order for payment through Stripe integration.",
        action: "Pay securely",
      },
      {
        title: "Manage inventory",
        description:
          "Admins update products, review orders, and keep fulfillment organized.",
        action: "Open admin",
      },
    ],
  },
  {
    slug: "forex-trading-bot",
    title: "Trading Bot Logic Flow",
    tagline: "A decision console for signals, execution, and risk management.",
    audience: "Trading tool builders and automation-focused founders",
    outcome: "Strategies can read market data, trigger trades, and control downside risk.",
    accent: "amber",
    steps: [
      {
        title: "Read market data",
        description:
          "Broker API feeds provide live price movement for strategy checks.",
        action: "Sync feed",
      },
      {
        title: "Evaluate signals",
        description:
          "Moving averages, RSI, and trend-following rules determine trade readiness.",
        action: "Run strategy",
      },
      {
        title: "Control risk",
        description:
          "Stop-loss, take-profit, and position sizing protect capital before execution.",
        action: "Apply risk",
      },
    ],
  },
];

export function getPrototype(slug: string) {
  return prototypes.find((prototype) => prototype.slug === slug);
}

export function getPrototypeProject(slug: string) {
  return projects.find((project) => project.slug === slug);
}
