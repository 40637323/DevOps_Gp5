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
There are three classes implemented. These classes are located under src/main/java/com.universal/
- App.java
- City.java
- Country.java
There are two classs for testing.These classes are located under /src/test/java/com/universal/
- AppTest.java
- AppIntegrationTest.java
Where: Unit testing is provided in AppTest.java and integrating testing is provided in AppIntegrationTest.java.

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
      - view-population
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

### 32 requirements of 32 have been implemented, which is 100%. 

| ID  | Name  | Met | Screenshot |
| --- | ----- | --- | ---------- |
| 1   | All the countries in the world organised by largest population to smallest. | Yes | ![image1.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image1.png)  |
| 2   | All the countries in a continent organised by largest population to smallest. | Yes | ![image2.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image2.png) |
| 3   | All the countries in a region organised by largest population to smallest.   | Yes | ![image3.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image3.png) |
| 4   | The top 7 populated countires in the world where 7 is provided by the user.   | Yes | ![image4.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image4.png) |
| 5   | The top 7 populated countries in the continent where 7 is provided by the user.   | Yes | ![image5.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image5.png) |
| 6   | The top 7 populated countries in a region where 7 is provided by the user.  | Yes | ![image6.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image6.png)  |
| 7   | All the cities in the world organised by largest population to smallest.   | Yes | ![image7.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image7.png) |
| 8   | All the cities in a continent organised by largest population to smallest.   | Yes | ![image8.jpg](https://github.com/40637323/DevOps_Gp5/blob/master/images/image8.jpg) |
| 9   | All the cities in a region organised by largest population to smallest.   | Yes | ![image9.jpg](https://github.com/40637323/DevOps_Gp5/blob/master/images/image9.jpg) |
| 10   | All the cities in a country organised by largest population to smallest.   | Yes | ![image10.jpg](https://github.com/40637323/DevOps_Gp5/blob/master/images/image10.jpg) |
| 11   | All the cities in a district organised by largest population to smallest.   | Yes | ![image11.jpg](https://github.com/40637323/DevOps_Gp5/blob/master/images/image11.jpg) |
| 12   |The top 7 populated cities in the world where 7 is provided by the user.   | Yes | ![image12.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image12.png)  |
| 13   |The top 7 populated cities in a continent where 7 is provided by the user.   | Yes | ![image13.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image13.png) |
| 14   |The top 7 populated cities in a region where 7 is provided by the user.   | Yes | ![image14.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image14.png)  |
| 15   |The top 7 populated cities in a country where 7 is provided by the user.   | Yes | ![image15.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image15.png) |
| 16   |The top 7 populated cities in a district where 7 is provided by the user.   | Yes | ![image16.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image16.png) |
| 17   |All the capital cities in the world organised by largest population to smallest.   | Yes | ![image17.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image17.png) |
| 18   |All the capital cities in a continent organised by largest population to smallest.   | Yes | ![image18.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image18.png) |
| 19   |All the capital cities in a region organised by largest to smallest.   | Yes | ![image19.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image19.png) |
| 20   |The top 7 populated capital cities in the world where 7 is provided by the user.   | Yes | ![image20.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image20.png) |
| 21   |The top 7 populated capital cities in a continent where 7 is provided by the user.   | Yes | ![image21.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image21.png) |
| 22   |The top 7 populated capital cities in a region where 7 is provided by the user.   | Yes | ![image22.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image22.png) |
| 23   |The population of people, people living in cities, and people not living in cities in each continent.   | Yes | ![image23.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image23.png) |
| 24   |The population of people, people living in cities, and people not living in cities in each region.   | Yes | ![image24.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image24.png) |
| 25   |The population of people, people living in cities, and people not living in cities in each country.   | Yes | ![image25.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image25.png) |
| 26   |The population of the world.   | Yes | ![image26.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image26.png) |
| 27   |The population of a continent.   | Yes | ![image27.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image27.png) |
| 28   |The population of a region.   | Yes | ![image28.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image28.png) |
| 29   |The population of a country.   | Yes | ![image29.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image29.png) |
| 30   |The population of a district.   | Yes | ![image30.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image30.png) |
| 31   |The population of a city.   | Yes | ![image31.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image31.png) |
| 32   |Language Speakers Report.   | Yes | ![image32.png](https://github.com/40637323/DevOps_Gp5/blob/master/images/image32.png) |
| ... | ...   | ... | ...        |
