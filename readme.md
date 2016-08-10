# Billing Service	

## Scenario

Cafe X menu consists of the following items:

- Cola - Cold - 50p
- Coffee - Hot - £1.00
- Cheese Sandwich - Cold - £2.00
- Steak Sandwich - Hot - £4.50

Customers don’t know how much to tip and staff need tips to survive!

Write some code to generate a bill including a service charge so customers don’t have to work out how much to tip.

---

#### Exercise 1 – Service Charge
###### _(25 Minutes)_

Pass in a list of purchased items that produces a total bill When all purchased items are drinks no service charge is applied When purchased items include any food apply a service charge of 10% to the total bill (rounded to 2 decimal places)


---

#### Exercise 2 – Hot Food
###### _(20 Minutes)_

When purchased items include any hot food apply a service charge of 20% to the total bill to a max of £20

---

#### Exercise 3 – Premium Menu Items
###### _(15 Minutes)_

Lobster, a premium item, is added to the menu at a cost of £25 When purchased items include any premium food apply a service charge of 25% to the total bill to a max of £40

---

#### Exercise 4 – Loyalty Scheme
###### _(30 Minutes)_

Some customers are issued a loyalty card with star for every consecutive months the customer has spent £20 or more in a single visit in each
month

Submitting a loyalty card along with the purchased items will reduce the total bill (before service charge is applied) by 2.5% for every star
(min: 3, max: 8).

Example: A customer with loyalty card with 10 stars will reduce the total bill by 20% (8 stars * 2.5%)

Loyalty discount is not applied to premium menu items

---

#### Alternative Exercise 4 – Loyalty Scheme
###### _(30 Minutes)_

Some customers are issued a loyalty card with star for every consecutive months the customer has spent £20 or more in a single visit in each month

Submitting a loyalty card along with the purchased items will apply a rolling reduction on the total (before service charge is applied) by 2.5% for every star (min: 3, max: 8).

Example: A customer with loyalty card with 3 stars will reduce a total bill of £100 to £78.16: ```((£100 - 2.5%) - 2.5%) - 2.5%```

Loyalty discount is not applied to premium menu items

---

#### Alternative Exercise 4 – Non-Blocking Code (Scala Only)
###### _(30 Minutes)_

All products must be retrieved using a call to a microservice over HTTP. A component has been developed to retrieve the the prices taking in an sequence of strings and returning a `Future[Seq[MenuItem]]`.

Update your code to call the components `.getItems(items: Seq[String])` function. Ensure your code is asynchronous and does not block the thread.


