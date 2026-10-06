
Hybrid Bridging
A client-side Fabric mod for Minecraft Java 1.21.1 that keeps normal vanilla block placement whenever it already works, while adding a Bedrock-style fallback search when vanilla placement cannot find a valid block face.
Designed for edge bridging, diagonal bridging, and placing blocks while moving.
> Client-side only. No server installation required.
> 
✨ Features
 * Vanilla placement first — normal Minecraft placement always takes priority.
 * Fallback placement — activates only when the vanilla raycast misses or does not hit a block.
 * Edge assistance — helps find useful placements when bridging over gaps.
 * Diagonal assistance — improves fallback placement while moving diagonally.
 * Configurable search — customize the fallback search radius and placement tolerance.
 * No movement modification — does not change player movement or input.
 * No reach modification — does not increase block reach.
 * No physics modification — Minecraft's normal physics remain unchanged.
 * Client-side — the server does not need to install the mod.
🧠 How It Works
Hybrid Bridging uses a two-stage placement system:
             Player attempts placement
                       │
                       ▼
                Vanilla raycast
                       │
                 ┌─────┴─────┐
                 │           │
                Hit         Miss
                 │           │
                 ▼           ▼
          Vanilla placement  Fallback search
                 │           │
                 └─────┬─────┘
                       ▼
                Selected placement

1. Vanilla Placement
If the normal Minecraft crosshair raycast hits a valid block face, Hybrid Bridging leaves the placement completely alone.
Vanilla wins whenever possible.
2. Fallback Placement
If the vanilla raycast misses, the mod searches nearby blocks for possible placement anchors.
Candidates are evaluated based on factors such as:
 * Distance from the player
 * Distance from the crosshair line
 * Placement direction
 * Player movement direction
 * Edge position
 * Diagonal movement
The highest-scoring valid candidate is then selected for the placement attempt.
⚙️ Configuration
On first launch, the mod automatically creates:
config/bridging-mod.json
Options
| Option | Default | Description |
|---|---|---|
| enabled | true | Master toggle for hybrid placement. |
| fallbackSearchRadius | 3 | Block radius around the player used for fallback searches. |
| placementTolerance | 0.25 | How far a candidate can be from the crosshair line. |
| edgeAssistance | true | Assists with placements when bridging over a gap ahead of the player. |
| diagonalAssistance | true | Biases fallback scoring when moving diagonally relative to the player's facing direction. |
Example Configuration
{
  "enabled": true,
  "fallbackSearchRadius": 3,
  "placementTolerance": 0.25,
  "edgeAssistance": true,
  "diagonalAssistance": true
}

> Note: Close Minecraft before editing the configuration manually. Restart the game after making changes.
> 
📦 Requirements
 * Minecraft Java Edition 1.21.1
 * Fabric Loader 0.16.10+
 * Fabric API
🚀 Installation
 * Install Fabric Loader
   Install Fabric Loader for Minecraft 1.21.1.
 * Install Fabric API
   Download Fabric API and place the .jar file in your Minecraft mods folder.
 * Install Hybrid Bridging
   Download the latest release (bridging-mod-*.jar) and place it in .minecraft/mods/ (or %appdata%\.minecraft\mods\ on Windows).
 * Launch Minecraft
   Start Minecraft using your Fabric 1.21.1 profile. The configuration file will be generated automatically on first launch.
🛠️ Building From Source
Clone the repository:
git clone https://github.com/RAYYAN-HTML/bridging-mod.git
cd bridging-mod

Windows:
.\gradlew build

Linux / macOS:
./gradlew build

The compiled JAR will be generated in build/libs/ (for example, build/libs/bridging-mod-1.0.0.jar).
🧪 Running Tests
Windows:
.\gradlew test

Linux / macOS:
./gradlew test

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

🎯 Design Goals
 * Vanilla First: The mod should never interfere with a placement that Minecraft can already perform normally.
 * Fallback Only When Necessary: Custom placement logic runs only when the standard raycast cannot provide a valid block placement.
 * No Movement Manipulation: Hybrid Bridging does not modify player movement, sprinting, sneaking, jumping, player speed, reach distance, or game physics.
 * Client-Side Only: The mod is designed to operate entirely on the client. No server-side installation is required.
⚠️ Compatibility
| Component | Version |
|---|---|
| Minecraft | 1.21.1 |
| Mod Loader | Fabric |
| Fabric Loader | 0.16.10+ |
| Side | Client-side |
Other Minecraft versions may require code changes and are not currently guaranteed to work.
🤝 Contributing
Contributions, bug reports, and feature requests are welcome.
When reporting an issue, please include:
 * Minecraft version
 * Fabric Loader version
 * Fabric API version
 * Hybrid Bridging version
 * Configuration
 * Steps to reproduce
 * Relevant logs
 * Screenshots or video when useful
Pull requests are welcome as well.
📄 License
See LICENSE for licensing information.
⭐ Support
If you find Hybrid Bridging useful, consider giving the repository a ⭐ star!
Found a bug or have an idea? Open an issue or submit a pull request.
