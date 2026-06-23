import Image from "next/image";

type GenesisLogoProps = {
  showText?: boolean;
};

export default function GenesisLogo({ showText = true }: GenesisLogoProps) {
  return (
    <div className="genesis-brand" aria-label="Genesis Inc">
      <Image
        className="genesis-mark"
        src="/assets/logo/human-ai-yinyang.png"
        alt=""
        aria-hidden="true"
        width={38}
        height={38}
      />
      {showText && (
        <span>
          Genesis <strong>Inc</strong>
        </span>
      )}
    </div>
  );
}
