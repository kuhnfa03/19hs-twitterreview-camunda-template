# Twitterrep ZHAW
Examplerepository ZHAW for Twitterreview process. Use this Repo for future reference regarding camunda projects.

#### Branches
- Master: Björn Musterlösungen
- Develop: Notes in Lessons (merge this when semester is over)

#### Run Project
- Start Backend Rest Service that sends User: [19hs-twitterreview-userservice](https://github.com/kuhnfa03/19hs-twitterreview-userservice)
- Create File `twitter4j.properties`, based on `twitter4j-example.properties`
- Create File `mail.properties`, based on `mail-example.properties`

#### Project Structure
- `ForbiddenWords.dmn` contains decision table
- `TweetRequestApprovalProcess` contains main Process of Tweet Requests
#### Sync Repo with Upstream
Add upstream Repo if Necessary
```
$ git remote add upstream git@github.com:zhaw-gpi/19hs-twitterreview-musterloesung.git
```
Sync with upstream Repo
```
$ git fetch upstream
$ git checkout master
$ git merge upstream/master
```
