## Web Scraper


## Simple web scraper written in Java using Jsoup
### Educational site is scraped for all courses with visible href and courses and description are output to Json file named course.json
### Also included is how an entity would be mapped to contain this information, with more time more information could be gathered from the site to complete the entity. 

## Lessons Learned
* Jsoup doesn't seem to have a good way to click inactive elements.
* When all elements are retrieved from multiple pages with Jsoup a 2d array is created. Traversing that array is slow.
* Nested connects are extremely slow and parallel connects are hard to read and messy.

## Time to complete this was about 8 hours including research into webscrapers  
