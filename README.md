# Dutch

![dutch] [dutch]

## Overview

Dutch is a command-line app which uses the [Amazon MWS Products API] [apidoc] to check your competitors' prices on Amazon Marketplace. Dutch is written in Scala.

## Usage

Usage of Dutch is as per the command-line help:

    dutch: Version 0.1. Copyright (c) 2012, Orderly Ltd.

    Usage: dutch [OPTIONS] outputfile [input] ...

    OPTIONS
    -c filename
    --config filename  Configuration file. Defaults to "resources/example.conf"
		       (within .jar) if not set
    -n
    --noheader         Flags that input CSV file(s) does not have a header row
    -q sep
    --quote sep        Quote character to use for CSVs (defaults to ")
    -s sep
    --separator sep    Separator character to use for CSVs (defaults to ,). Use \t
		       for tab

    PARAMETERS
    outputfile  Output CSV file to write
    input       Input CSV file(s) to read. If not specified, uses stdin (May be
		specified multiple times.)

## Copyright and License

Dutch uses the Marketplace Web Service Products Java Library, copyright
2008 [Amazon Technologies, Inc](http://www.amazon.com/). You can find this
library in the `/lib` sub-directory.

The rest of Dutch is copyright 2012 Orderly Ltd. 

Licensed under the [Apache License, Version 2.0] [license] (the "License");
you may not use this software except in compliance with the License.

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

[dutch]: https://github.com/datascience/dutch/raw/master/doc/schultz.jpg
[apidoc]: https://developer.amazonservices.com/gp/mws/api.html/192-0013333-8270332?ie=UTF8&section=products&group=products&version=latest
[amazon]: http://www.amazon.com/
[license]: http://www.apache.org/licenses/LICENSE-2.0
