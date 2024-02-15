# SET09623 DevOps (Group-5)

## Purpose: 
To generate population reports for city, country, continent, region, capital, world and distirct with different circumstances using SQL database provided by the organization. So that consumers can easily view on the reports with the information they want.

## Installation: 
- IntelliJ IDEA 2023.3.2
- Latest Docker Desktop
- Docker Integration including Docker Compose
- Continuous Integration (CI) [GitHub Actions]
- Deploying self-contained JAR
- Running MySQL driver
- Connection to Database

## Dependency
- mysql-connector-java (Version - 8.0.25)
- junit-jupiter-api (Version - 5.1.0)
- junit-platform-surefire-provider (Version - 1.1.0)
- junit-jupiter-engine (5.1.0)

## Plugin
- maven-assembly-plugin (Version - 3.3.0)

## Project Structure
There are five classes implemented. These classes are located under src/main/java/com.universal/
- App.java
- City.java
- Country.java
- Countrylanguage.java
- Main.java

## Code of Conduct:
- School late - 1 mark
- School absent - 2 marks
- Does not complete assign to you - 4 marks
- Leave the class early - 1 mark
- Meeting late - 1 mark
- Argument with team member - 2 marks
- Playing games, watching YouTube - 1 mark
- Meeting absent - 2 marks
- Doesn’t listen to teammates - 1 mark
- Lies to the team members that he completes the task - 1 mark

## Branches
- master
  - develop
    - feature
      - all-view
      - top_n_population
      - view-record
  - release

## Tests:
- Unit Testing (Pass)
- Continuous Integrating Testing (Pass)

## Members

- Project Owner - Pwint Phoo Wai (40637323@live.napier.ac.uk)

- Scrum Manager - Phoo Thwin Cho (40637326@live.napier.ac.uk)

- Technical Writer - Su Thiri Htun (40632022@live.napier.ac.uk)

- Developer - Pa Pa Myint Aung (40637324@live.napier.ac.uk)

- Developer - Hein Wai Yan Soe (40637318@live.napier.ac.uk)

- Developer - Hein Htet Naing (40632027@live.napier.ac.uk)

# Necessary Badges

Master Build Status ![workflow](https://github.com/40637323/DevOps_Gp5/actions/workflows/main.yml/badge.svg)

Develop Build Status ![workflow](https://img.shields.io/github/actions/workflow/status/40637323/sem/.github%2Fworkflows%2Fmain.yml?)

Code Cov [![codecov](https://codecov.io/gh/40637323/DevOps_Gp5/graph/badge.svg?token=W4ZP8XRJ8I)](https://codecov.io/gh/40637323/DevOps_Gp5)

License [![LICENSE](https://img.shields.io/github/license/40637323/sem.svg?style=flat-square)](https://github.com/40637323/DevOps_Gp5/blob/master/LICENSE)

Release [![Releases](https://img.shields.io/github/release/40637323/DevOps_Gp5/all.svg?style=flat-square)](https://github.com/40637323/DevOps_Gp5/releases)

## Requirement Evidence

| ID  | Name  | Met | Screenshot |
| --- | ----- | --- | ---------- |
| 1   | All the countries in the world organised by largest population to smallest. | Yes | ![image1.jpg](https://github.com/40637323/DevOps_Gp5/blob/master/images/image1.jpg)  |
| 2   | All the countries in a continent organised by largest population to smallest. | Yes | ![Screenshot](image2.png)
| 3   | All the countries in a region organised by largest population to smallest.   | Yes | ![image3.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image3.png) |
| 4   | The top 7 populated countires in the world where 7 is provided by the user.   | Yes | ![image4.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image4.png) |
| 5   | The top 7 populated countries in the continent where 7 is provided by the user.   | Yes | ![image5.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image5.png) |
| 6   | The top 7 populated countries in a region where 7 is provided by the user.  | Yes | ![Screenshot](image6.png) |
| 7   | All the cities in the world organised by largest population to smallest.   | Yes | ![Screenshot](image7.png) |
| 8   | All the cities in a continent organised by largest population to smallest.   | Yes | ![image8.jpg](https://github.com/40637323/DevOps_Gp5/blob/master/images/image8.jpg) |
| 9   | All the cities in a region organised by largest population to smallest.   | Yes | ![Screenshot](image9.png) |
| 10   | All the cities in a country organised by largest population to smallest.   | Yes | ![Screenshot](image10.png) |
| 11   | All the cities in a district organised by largest population to smallest.   | Yes | ![Screenshot](image11.png) |
| 12   |The top 7 populated cities in the world where 7 is provided by the user.   | Yes | ![Screenshot](image12.png) |
| 13   |The top 7 populated cities in a continent where 7 is provided by the user.   | Yes | ![Screenshot](image13.png) |
| 14   |The top 7 populated cities in a region where 7 is provided by the user.   | Yes | ![Screenshot](image14.png) |
| 15   |The top 7 populated cities in a country where 7 is provided by the user.   | Yes | ![Screenshot](image15.png) |
| 16   |The top 7 populated cities in a district where 7 is provided by the user.   | Yes | ![Screenshot](image16.png) |
| 17   |All the capital cities in the world organised by largest population to smallest.   | Yes | ![Screenshot](image17.png) |
| 18   |All the capital cities in a continent organised by largest population to smallest.   | Yes | ![Screenshot](image18.png) |
| 19   |All the capital cities in a region organised by largest to smallest.   | Yes | ![Screenshot](image19.png) |
| 20   |The top 7 populated capital cities in the world where 7 is provided by the user.   | Yes | ![Screenshot](image20.png) |
| 21   |The top 7 populated capital cities in a continent where 7 is provided by the user.   | Yes | ![Screenshot](image21.png) |
| 22   |The top 7 populated capital cities in a region where 7 is provided by the user.   | Yes | ![Screenshot](image22.png) |
| 23   |The population of people, people living in cities, and people not living in cities in each continent.   | Yes | ![Screenshot](image23.png) |
| 24   |The population of people, people living in cities, and people not living in cities in each region.   | Yes | ![Screenshot](image24.png) |
| 25   |The population of people, people living in cities, and people not living in cities in each country.   | Yes | ![Screenshot](image25.png) |
| ... | ...   | ... | ...        |
