# Scalable Vector Desktop

An experimental desktop/window manager implemented as a single Scalable Vector Graphics document.

## Overview

Vector computer displays are not new. Some of the very earliest computer [visual display units were natively vector](https://en.wikipedia.org/wiki/Vector_monitor); more recently, [NeXTStep](https://en.wikipedia.org/wiki/NeXTSTEP) used [Display Postscript](https://en.wikipedia.org/wiki/Display_PostScript) to create an essentially vector display.

Vector displays have many advantages: they are intrinsically scalable, meaning they can be zoomed arbitrarily without ugly artifacts, and they can adapt cleanly to the physical resolution of the device being used.

Vector representations can also be easily represented as lists, making them easy to manipulate in virtually any computer language, but that they have a special affinity to Lisps.

## Programme

This project (`svd`) is essentially experimental/proof of concept. The end goal is a window manager for the [Post Scarcity Software System](https://github.com/simon-brooke/post-scarcity), which will almost certainly never be completed. So I don't imagine this project will be directly useful to anyone, except as a proof of concept.

## Setup

To get an interactive development environment run:


    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## License

Copyright © 2023 [Simon Brooke](mailto:simon@journeyman.cc)

Distributed under the GNU General Public License either version 2.0 or (at your option) any later version.
