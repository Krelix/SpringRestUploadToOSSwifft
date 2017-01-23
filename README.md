### Spring REST File Upload and OpenStack Swift Storage

This project is a simple REST server that receives Files and saves them in an Open Stack Swift storage server.

### Pre-requisite

This package requires the installation of OpenStack's Swift. The way this is set up is using Swift Only One, from this github repository : https://github.com/tburnett80/docker-swift-onlyone.git

The parameters are hard coded (for now) in StorageController and should be modified to access Swift on your environment.

### Uploading a document

By running `mvn package spring-boot:run`, a local application will be run that provides a static HTML file with an upload form in multipart.

Spring REST handles calling the `/upload` endpoint to obtain the file as a MultipartFile and give  its byte content to the Storage Controller, which will then savee it to Swift (after login and creation of the document container)


