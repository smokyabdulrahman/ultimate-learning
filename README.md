# ultimate-learning
In this project I will implement things I will learn


## Shorten Url Project
### To be implemented
- [ ] Statistics about url visits.
  - [ ] Number of visits.
  - [x] Type of device clicked on url.
  - [ ] Ip address.
  - [x] Time
  - [ ] From which platform. (How to know that?)
    - [ ] Maybe generate differnt shorturls (add flags) 
- [ ] Global Exception handling the proper way.
  - [x] ResourceNotFound.
  - [ ] DuplicateEntry.
- [ ] Frontend:
  - [ ] UI to generate short urls.
  - [ ] UI to share genereated short urls.
- [ ] Timed short urls (worker to clear urls - softdelete)
- [ ] Custom short urls (write custome text as slug)
- [ ] Horizontal scaling of auto-generated shorturls. (use queues to store pre-generated slugs)
- [ ] User profiles
  - [ ] Track your short url
  - [ ] Delete short urls
  - [ ] See statistics of shorturls
  - [ ] Auth only shorturls (user must be logged in and in list to be able to go to the destination).