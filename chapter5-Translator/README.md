# chapter5-translator

## Screenshot of the application

![Screenshot_1638348495](https://user-images.githubusercontent.com/58338486/144201847-d03d0763-332c-4445-acae-99dffcd12ac0.png)

* Only implement basic functions with a simple UI.
* Using handler to avoid error "Accessibility content change on non-UI thread.".

## WireShark to capture packets

1. From DNS packets we can see that our destination IP address is 123.123.219.80.

   ![DNS](https://user-images.githubusercontent.com/58338486/144201841-dafcd24b-6bfa-44d8-a681-11c0f7c890fd.png)

2. Then we can use `ip.addr==123.123.219.80` to filter packets we need. Finally we get TCP and TLS packets.

   ![TCP&TLS](https://user-images.githubusercontent.com/58338486/144201849-d3682ae7-c3cf-4682-97b5-c9176aa0b567.png)

The result of packet capture using WireShark is [here](https://github.com/ADSWT518/android-develop-bytedance/files/7632332/wireshark-result.zip).
