# Spod-Proc

A very rudimentary data manipulation tool for processing my spodify extended logs.

Mostly used for things like sorting json files and counting how many times I listened to a song on one day/week/month/etc.

## Dependencies Required
Gson 2.9.0 || >
hamcrest-core-1.3 || >
junit-4.13.2 || >

### The Plan
- [x] Convert Json file to object
- [x] Make a sortable list of said objects
- [x] Sort by TS
- [ ] Sort by times listened
- [ ] Get all the diffrent reasonstart and reasonend values and make an enum with them
- [ ] Sort by device used 