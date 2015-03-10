10006
=====

Status: **TLE**

I first tried a prime check first then the Fermat prime check second, giving me TLE. Swapping these checks also gave me TLE.

My next course of action was to optimize the modPow function. I looked at Wikipedia and it gave me a nice right-to-left algorithm, which I implemented. I was no longer getting TLE here.

However, I was getting wrong answer. It turns out that I was getting integer overflow from my new modPow method, so I used `long`s within the method instead and everything was fixed.

