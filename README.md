# x-prem
# Getting Started
## ana uygulama- main
* url(get): http://localhost:8080/profile/get/email?email=abc@email.com
* url(post): http://localhost:8080/os/create/support/request
`body:
{
    "email":"xyz@email.com",
    "subject":"subject",
    "message":"message message message 6"
}`
* url(post): http://localhost:8080/profile//change/statu
`body:
{
    "email":"xyz@email.com",
    "newMembershipStatu":"SUBSCRIBER"
}`
## ödeme servisi- payment
* url(post): http://localhost:8090/payment/checkout
`body: { "name":"AA BB",
    "no":"4716491497988657",
    "expiryDate":"12/26",
    "cvc":"123"
}`
