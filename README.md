# techtest

This proyect is the solution to a technical test

## Technical test description

In the company's e-commerce database we have the PRICES table that reflects the final price and the
rate that applies to a chain product between certain dates. Below is an example of the table with the
relevant fields:

PRICES

-------------

BRAND_ID | START_DATE | END_DATE | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE |
CURR

------------------------------------------------------------------------------------------------------------------------------------------
------------

1 2020-06-14-00.00.00 2020-12-31-23.59.59 1 35455 0 35.50 EUR

1 2020-06-14-15.00.00 2020-06-14-18.30.00 2 35455 1 25.45 EUR

1 2020-06-15-00.00.00 2020-06-15-11.00.00 3 35455 1 30.50 EUR

1 2020-06-15-16.00.00 2020-12-31-23.59.59 4 35455 1 38.95 EUR

Fields:

* BRAND_ID: foreign key of the group (1 = XYZ).
* START_DATE, END_DATE: range of dates in which the indicated rate price applies.
* PRICE_LIST : Identifier of the applicable price list.
* PRODUCT_ID: Product code identifier.
* PRIORITY: Price application disambiguator. If two rates coincide in a range of dates, the one with the
highest priority (highest numerical value) is applied.
* PRICE : final sale price.
* CURR: currency in iso.

What is requested:

Build an application/service in SpringBoot that provides a rest endpoint such that:

* Accept as input parameters: Application Date, Product Identifier, String Identifier.
* Return as output data: product identifier, chain identifier, rate to apply, dates of application and final
price to apply.
* An in-memory database (e.g. h2) must be used and initialized with the data from the example (you can
change the name of the fields and add new ones if you want, choose the data type that is considered
appropriate for them).

Develop some tests of the rest endpoint that validates the following requests of the service with the
example data:

* Test 1: request at 10:00 a.m. on the 14th for product 35455 for brand 1 (XYZ)
* Test 2: request at 4:00 p.m. on the 14th for product 35455 for brand 1 (XYZ)
* Test 3: request at 9:00 p.m. on day 14th for product 35455 for brand 1 (XYZ)
* Test 4: request at 10:00 a.m. on the 15th for product 35455 for brand 1 (XYZ)
* Test 5: request at 9:00 p.m. on day 16th for product 35455 for brand 1 (XYZ)

What Will be valued:

* Design and construction of the service.
* Code Quality.
* Correct results in the tests.


## Development considerations

* Technical test description ask to implement a service that includes in the result the rate to apply. But in the database model it doesn't say anithing related with this rate. I assume that "rate" is some kind of percentage, and add it as a field in the data model with some random values
* CURR field will be called CURRENCY in my databae model
* I don't know what chainId as is not described in the model description, I assume that is not important for the test purposes so I ommited it
* H2 database will be automatically loaded with the data described in the test description
* Only the requested unit tests have been implemented, and it is only verified that the final price is correct


