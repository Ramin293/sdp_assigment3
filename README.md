# Assignment 3 - Bridge Pattern

- **Name:** Ramin Smagulov
- **Group:** SE-2529
- **Topic:** A - Shape Drawing
- **Repository URL:** https://github.com/Ramin293/sdp_assigment3.git
- **Base commit:** `a388d3a709629b6e147ce1e3e1bfb1cab61b0bcc`

The abstraction hierarchy describes **what** is drawn (`Circle` or `Square`).
The implementation hierarchy describes **how** it is represented (`VectorRenderer`,
`RasterRenderer`, or `AsciiRenderer`). A `Shape` contains a `Renderer` reference,
so either kind of shape can use any renderer without combination subclasses.

| Bridge role | Class | Source |
| --- | --- | --- |
| Abstraction | `Shape` | `src/Shape.java` |
| A1 | `Circle` | `src/Circle.java` |
| A2 | `Square` | `src/Square.java` |
| Implementor | `Renderer` | `src/Renderer.java` |
| I1 | `VectorRenderer` | `src/VectorRenderer.java` |
| I2 | `RasterRenderer` | `src/RasterRenderer.java` |
| I3 | `AsciiRenderer` | `src/AsciiRenderer.java` |
| Client | `Main` | `src/Main.java` |

The bridge field `private Renderer implementation`, public `execute()`, and
`setImplementation(Renderer)` are in `src/Shape.java`. `Circle.execute()` and
`Square.execute()` delegate to the stored renderer. The T5 identity and state
check is in `src/Main.java`.

## Build and run

From the `assignment3` folder, using JDK 17 or newer:

```text
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

The demo uses radius 2, side 3, and fixed shape IDs. Each result is checked
against the expected string; `PASS` and the summary are calculated at runtime.

| Check | Expected outcome |
| --- | --- |
| T1 | `VECTOR circle radius=2` |
| T2 | `RASTER circle radius=2 (pixels)` |
| T3 | `VECTOR square side=3` |
| T4 | `RASTER square side=3 (pixels)` |
| T5 | The same `Circle` object (`==`) retains ID `C-02` and radius `2`; output changes from `VECTOR circle radius=2` to `RASTER circle radius=2 (pixels)`. |
| T6 | `ASCII circle radius=2: (o)` |
| T7 | `ASCII square side=3: [#]` |

Expected summary: `SUMMARY: 7/7 PASS`. The exact captured run is in
`demo-output.txt`.

## Extension evidence

The base commit contains I1/I2 and T1-T5. The extension commit
`4ddec053b318f416ab4789f25ba271d7c55da6e9` adds `AsciiRenderer` and T6/T7.
`extension.diff` was generated from the base commit to the extension commit for
`src/`; it changes only `src/Main.java` and adds `src/AsciiRenderer.java`.

## References

- Assignment 3 course handout (provided via Moodle), Sections 2-6.
- [Bridge pattern](https://refactoring.guru/design-patterns/bridge), Refactoring.Guru.
- [Adapter pattern](https://refactoring.guru/design-patterns/adapter), Refactoring.Guru.
- [Java 17 `Objects` API](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Objects.html), Oracle.
