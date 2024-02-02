# Use Case 9
All the cities in a region organized by largest population to smallest.
## CHARACTERISTIC INFORMATION
### Goal in Context
As an analyst, I want to see all the cities in a region organized by largest population to smallest so that I can easily access the related population information.
### Scope
Organizational black box
### Level
User goals
### Preconditions
The system will connect the World database successfully.
### Success End Condition
The analyst generates population report about the cities in the region organized by largest population to smallest and it meets the organization’s request.
### Failed End Condition
The system generates population report for the cities in the region as an empty list.
### Primary Actor
Analyst
### Trigger
An organization will make a request to get the report of the population of all the cities in the region sorted from largest to smallest.
### Main Success Scenario
1.  The analyst generates report for the sorted population list of cities in the region from largest to smallest.
2.  The system extracts the population data for the cities in the region from largest to smallest.
3.  The system shows a clear and readable list of cities’ population from largest to smallest.
### Extensions
In Step 2, the system unable to extract the required data for the organization and generate empty list.
### Sub-Variations
None
### SCHEDULE
Due Date:2.2.2024
