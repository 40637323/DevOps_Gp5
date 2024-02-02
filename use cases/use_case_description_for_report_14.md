# Use Case 14
The top N populated cities in a region where N is provided by the user.
## CHARACTERISTIC INFORMATION
### Goal in Context
As an analyst, I want list of the top 7 populated cities in a region so that I can focus on the most populated cities in a region.
### Scope
Organization black box
### Level
User goals
### Preconditions
The system will connect the World database successfully.
### Success End Condition
The analyst will generate a report for the top 7 populated cities in the region just as the organization’s request.
### Failed End Condition
The system generating the top 7 populated cities in the region as an empty list.
### Primary Actor
Analyst
### Trigger
An organization will make a request to get the report of the top 7 populated cities in the region. 
### Main Success Scenario
10.  The analyst request to generate report for the top 7 populated cities in the region.
11.  The system extracts the population data for the top 7 cities in the region.
12.  The system shows a clear and readable list of top 7 populated cities in the region. 
### Extensions
In Step 1, the analyst failure to request the report.
In Step 2, The system failed to extracts the population data and generate empty list.
### Sub-Variations
None
### SCHEDULE
Due Date:9.2.2024
