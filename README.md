Hybrid Bridging

A client-side Fabric mod for Minecraft Java 1.21.1 that improves block placement while bridging.

Hybrid Bridging keeps Minecraft's normal vanilla block placement whenever it works. When the vanilla crosshair raycast cannot find a valid block face, the mod performs a Bedrock-style fallback search to find a suitable placement position.

This is especially useful for edge bridging, diagonal movement, and placing blocks while moving.

«Client-side only. No server installation is required.»

---

✨ Features

- Vanilla placement first — normal Minecraft placement always takes priority.
- Fallback placement — activates only when the vanilla raycast misses or does not hit a block.
- Edge assistance — helps find useful placements when bridging over gaps.
- Diagonal assistance — improves fallback placement while moving diagonally.
- Configurable search — adjust search radius and placement tolerance.
- No movement changes — does not modify player movement or input.
- No reach changes — does not increase block reach.
- No physics changes — Minecraft's normal physics remain untouched.
- Client-side — the server does not need the mod installed.

---

🧠 How It Works

Hybrid Bridging uses a simple two-stage placement system:

Player attempts to place a block
            │
            ▼
   Vanilla raycast check
            │
       ┌────┴────┐
       │         │
      Hit      Miss
       │         │
       ▼         ▼
 Vanilla      Fallback
 placement     search
       │         │
       └────┬────┘
            ▼
      Selected placement

1. Vanilla placement

If Minecraft's normal crosshair raycast hits a valid block face, Hybrid Bridging does nothing special and allows the normal placement behavior to happen.

2. Fallback placement

If the vanilla raycast misses, the mod searches nearby blocks for a suitable placement anchor.

Candidates are evaluated using factors such as:

- Distance from the player
- Distance from the crosshair line
- Placement direction
- Player movement direction
- Edge position
- Diagonal movement

The best valid candidate is then used for the placement attempt.

---

⚙️ Configuration

The configuration file is automatically created on first launch:

config/bridging-mod.json

Default Configuration

Option| Default| Description
"enabled"| "true"| Enables or disables hybrid placement.
"fallbackSearchRadius"| "3"| Radius around the player's position used when searching for fallback anchors.
"placementTolerance"| "0.25"| Maximum allowed distance between a candidate and the crosshair line.
"edgeAssistance"| "true"| Improves fallback placement when bridging over a gap ahead of the player.
"diagonalAssistance"| "true"| Adjusts fallback scoring when moving diagonally relative to the player's facing direction.

Example:

{
  "enabled": true,
  "fallbackSearchRadius": 3,
  "placementTolerance": 0.25,
  "edgeAssistance": true,
  "diagonalAssistance": true
}

«Close Minecraft before manually editing the configuration file, then restart the game for changes to take effect.»

---

📦 Requirements

- Minecraft Java Edition 1.21.1
- Fabric Loader 0.16.10 or newer
- Fabric API

---

🚀 Installation

1. Install Fabric

Install Fabric Loader for Minecraft 1.21.1.

2. Install Fabric API

Download Fabric API and place the ".jar" file inside your Minecraft "mods" folder.

3. Install Hybrid Bridging

Download the latest "bridging-mod-*.jar" release and place it inside:

.minecraft/mods/

4. Launch Minecraft

Start Minecraft using your Fabric 1.21.1 profile.

The configuration file will be generated automatically after the first launch.

---

🛠️ Building From Source

Clone the repository:

git clone https://github.com/YOUR_USERNAME/bridging-mod.git
cd bridging-mod

Windows — Gradle Wrapper

.\gradlew build

Linux / macOS

./gradlew build

The compiled mod will be available in:

build/libs/

For example:

build/libs/bridging-mod-1.0.0.jar

---

🧪 Running Tests

Windows:

.\gradlew test

Linux / macOS:

./gradlew test

---

📁 Project Structure

bridging-mod/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── gradle/
├── build.gradle
├── gradle.properties
├── settings.gradle
├── gradlew
└── gradlew.bat

---

🎯 Design Goals

Hybrid Bridging is designed around a few simple principles:

Vanilla first

The mod should never interfere with a placement that Minecraft can already perform normally.

Fallback only when necessary

The custom placement logic activates only when the standard raycast cannot provide a valid block placement.

No movement manipulation

The mod does not modify:

- Player movement
- Sprinting
- Sneaking
- Jumping
- Player speed
- Reach distance
- Game physics

Client-side only

The mod is intended to work entirely on the client and does not require a server-side installation.

---

⚠️ Compatibility

Hybrid Bridging is currently developed for:

Minecraft: 1.21.1
Loader:   Fabric
Side:     Client

Other Minecraft versions may require changes to the code and are not guaranteed to work.

---

🤝 Contributing

Contributions, bug reports, and suggestions are welcome.

If you find an issue:

1. Check whether it can be reproduced on Minecraft 1.21.1.
2. Check the existing GitHub issues.
3. Open a new issue with:
   - Minecraft version
   - Fabric Loader version
   - Fabric API version
   - Mod version
   - Configuration
   - Steps to reproduce
   - Relevant logs/screenshots

Pull requests are also welcome.

---

📄 License

See ""LICENSE"" (LICENSE) for the project's license.

---

⭐ Support

If you find Hybrid Bridging useful, consider giving the repository a ⭐ star on GitHub.

Bug reports, feature requests, and improvements are always appreciated.