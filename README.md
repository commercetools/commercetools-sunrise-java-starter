# Sunrise Java Starter Project
[![Build Status](https://travis-ci.org/commercetools/commercetools-sunrise-java-starter.svg?branch=master)](https://travis-ci.org/commercetools/commercetools-sunrise-java-starter)
[![Heroku](http://heroku-badge.herokuapp.com/?app=ct-sunrise-starter-prod&style=flat&svg=1)](http://ct-sunrise-starter-prod.herokuapp.com/)

Sunrise-based project using:
- [Sunrise Shop Framework](https://github.com/commercetools/commercetools-sunrise-java)
- [Sunrise Theme](https://github.com/commercetools/commercetools-sunrise-theme)
- [Play Web Framework 2.5.x](https://www.playframework.com/documentation/2.5.x/Home)

Use it as the starting point to develop your own online shop project.

## Preconditions

* Install [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (version >= 1.8.0_92)
* Create a [commercetools platform project](https://admin.sphere.io/en/signup) with some data
* Unless you modify the project to behave differently:
  * Product variants must contain a SKU without dashes `-`
  * Project must have at least a currency, country and language defined (unless you specify them via Sunrise configuration)

## Deployment

For an easy and fast deployment of your application we recommend [Heroku](https://www.heroku.com):

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

This will take you to the configuration page to create a Sunrise application in Heroku. Once you have created it, you can access and modify the source code of your application via Git, as explained in [Git Cloning Existing Heroku Applications](https://devcenter.heroku.com/articles/git-clone-heroku-app).

If Heroku reports that **you have cloned an empty repository** execute the following commands:
```bash
cd <project-folder>
git remote add origin https://github.com/commercetools/commercetools-sunrise-java-starter.git
git pull origin master
```
([Source](https://help.heroku.com/XOBUHLKQ/why-do-i-see-a-message-you-appear-to-have-cloned-an-empty-repository-when-using-heroku-git-clone))

## Run it locally

First, put the credentials of your commercetools platform project in `conf/dev.conf` as follows:

```properties
sunrise.ctp.client {
  projectKey = your-project-key
  clientId = your-client-id
  clientSecret = your-client-secret
  authUrl = "https://auth.sphere.io"
  apiUrl = "https://api.sphere.io"
}
```

If you have [SBT](http://www.scala-sbt.org/) on your computer you can run it with `sbt ~run`. Otherwise you can use the [Activator](https://www.lightbend.com/community/core-tools/activator-and-sbt) found in the project to run it locally:

* on Linux/Mac: `./activator ~run`
* on Windows: `activator ~run`

In any case, the output will be similar to:

```
[info] play - Listening for HTTP on /0:0:0:0:0:0:0:0:9000
(Server started, use Ctrl+D to stop and go back to the console...)
```

Now open <a href="http://localhost:9000">http://localhost:9000</a> in your browser and you should be able to access the web application using your project.
