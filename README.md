# What does the Plugin do?
This simple plugin is designed to manage builders and visitors on your build server. At its core, it gives builders and admins creativemode, while other visitors are immediately placed in spectatormode to protect the builds.\
## Features
- Adds a simple vanish for staffmembers
- Adds a Scoreboard.
- Adds a shortcut to creativemode for staffmember without giving staffmember access to vanilla commands.
- Adds simple prefixes in Tab.
- Adds welcome messages.

# Permissions and Commands
| **Commands**        |**Description**          | **Permissions**       |
|---------------------|-------------------------|-----------------------|
| /Build              | Shortcut to creativemode (so that you dont have to give builders access to vanilla commands)| build.team            |
| /hide               | Vanish yourself         | build.team            |
| /show               | Unvanish yourself       | build.team            |
| /hide <Player>      | Vanish other player     | build.admin           |
| /show <Player>      | Unvanish other player   | build.admin           |
| /jumpto <Player>    | Warp to another player  | build.team            |
| /sb <On/Off>        | Toggle the scoreboard for yourself| build.team            |


## Passive permissions
| **Passive properties**        |**Description**          | **Permissions**       |
|---------------------|-------------------------|-----------------------|
| Admin Prefix        | Display the Admin prefix in Tab          | build.admin           |
| Builder Prefix      | Display the Builder prefix in Tab        | build.team            |
| See vanished players| Be able to see vanished Players          | build.team            |

# Screenshots
Here are some screenshots that show how the plugin looks.
## Vanished Players
If a player is in vanish, there is a 'V' behind their name.\
Other team members can still see them.\
![Vanished player in tablist](https://cdn.modrinth.com/data/cached_images/b926947a6df79e36a6108ecdf33b756804ee881d_0.webp)
## Prefixes
### Admin in Tablist
![Admin in playerlist](https://cdn.modrinth.com/data/cached_images/34ef3f6e030e9206e2850c756066093ef14cc7d3.png)
### Buildere in Tablist
![Builder in tablist](https://cdn.modrinth.com/data/cached_images/158e56bad56e5cb0b235ae4f115c7301b8dab654.png)
### Visitor in Tablist
![Visitor in tablist](https://cdn.modrinth.com/data/cached_images/f33160a97c068e069b0b2b22383b7973da07fae2_0.webp)

## POV's
### Admin
![Admin POV](https://cdn.modrinth.com/data/cached_images/555c6e49767ced8b09ee0c15508b4af251323ab9_0.webp)
### Builder
![Builder POV](https://cdn.modrinth.com/data/cached_images/60fb1ab2b7aafc61eec012b89a9051fd818dd6e6_0.webp)
### Visitor
![Visitor POV](https://cdn.modrinth.com/data/cached_images/0901c78f3474dd674deb3c5be26d9dec1479e8ee_0.webp)

# Config
Some small settings can be edited in the config.yml
```
Buildsystem:
  ServerName: '&9&lBuildserver'
  Prefix: '&6BuildSystem'
```
# ToDo's
- Add prefixes in chat and over the players head.
- Make the scoreboard customisable.
- Make the prefixes customisable.
- Add option to turn scoreboard off permanently.
- Add "V" as an alias for hide and show.

## Some notes
I originally wrote this plugin for a friend, and to make sure it doesn't get lost, I want to share it here.
This is one of my first attempts at making a plugin, so feedback is appreciated! Since this is one of my first plugins, the code is certainly not perfect. I will clean it up and optimize it more and more over time.
