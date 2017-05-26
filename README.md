# oapserver
This is the server-side component of the [OAP Metadata Editor] (https://github.com/NOAA-PMEL/OAPMetadataEditor).

This server will:

1. Take an XML file from the client and return a JSON representative that can be used to populate the client for editing.
2. Take the JSON file, save it as Grails Domain objects and return an XML document to be saved on the local computer.
     * If the submited JSON has an expocode that matches an existing document, if the new document is valid the old one is replaced.
     * If the expocode does not eist and the document is valid the document is saved.
