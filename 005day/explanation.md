I started using a template for a more organized look

# Day 5: Cafeteria

## 💡 The Gist
Determine, whether a number (an ingredient-ID) is inside the given ranges (fresh ingredient-ID ranges)

---

## 🧩 Part 1: The Approach
**Logic:**
- Put the Ranges into Nodes in a Linkedlist
- Iterate through the inputs, and count fresh ingredients (the search for a fitting range is easily optimized)

O(log(n)) lookuptime (with binary search)

**Challenges:**

- What is a fitting Data Structure for this task?

---

## 😰 Part 2: The Twist
**Changes Required:**
We now have to count the amount of IDs that are considered fresh, given the Ranges, without double counting

**Optimization/Refactoring:** I used longs instead of BigIntegers; I handled the Ranges differently

---

## 🧠 Key Learnings & Gotchas
* **Java Concept:** Only use BigInteger if you really really have to
* **Mistake:** Starting to code without a plan **USE PAPER SKETCHES**
* **Improvement:** Well structured, clean range handling