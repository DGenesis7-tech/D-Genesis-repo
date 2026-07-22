import type { NextConfig } from "next";

const isGitHubPages = process.env.GITHUB_ACTIONS === "true";
const githubBasePath = "/D-Genesis-repo";

const nextConfig: NextConfig = {
  output: "export",
  trailingSlash: true,
  images: {
    unoptimized: true,
  },
  basePath: isGitHubPages ? githubBasePath : "",
  assetPrefix: isGitHubPages ? githubBasePath : "",
  reactCompiler: true,
};

export default nextConfig;