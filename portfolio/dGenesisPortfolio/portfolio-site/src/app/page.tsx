import About from "@/components/About";
import Contact from "@/components/Contact";
import Experience from "@/components/Experience";
import Footer from "@/components/Footer";
import Hero from "@/components/Hero";
import MatrixBackground from "@/components/MatrixBackground";
import Navbar from "@/components/Navbar";
import Projects from "@/components/Projects";
import Services from "@/components/Services";
import Skills from "@/components/Skills";

export default function Home() {
  return (
    <div className="relative min-h-screen overflow-hidden bg-zinc-950 text-zinc-100">
      <MatrixBackground />
      <Navbar />
      <main className="relative z-10">
        <Hero />
        <About />
        <Services />
        <Skills />
        <Projects />
        <Experience />
        <Contact />
      </main>
      <div className="relative z-10">
        <Footer />
      </div>
    </div>
  );
}
