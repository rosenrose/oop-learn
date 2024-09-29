package s07_clock;

import java.util.EnumSet;

public class SevenSegmentDisplay {
    public enum Segment {
        A, B, C, D, E, F, G
    }

    private final EnumSet<Segment> segments;

    public SevenSegmentDisplay(byte num) {
        assert (0 <= num && num < 10) : "Invalid Number: " + num;

        segments = switch (num) {
            case 0 -> EnumSet.range(Segment.A, Segment.F);
            case 1 -> EnumSet.of(Segment.B, Segment.C);
            case 2 -> EnumSet.of(Segment.A, Segment.B, Segment.D, Segment.E, Segment.G);
            case 3 -> EnumSet.of(Segment.A, Segment.B, Segment.C, Segment.D, Segment.G);
            case 4 -> EnumSet.of(Segment.B, Segment.C, Segment.F, Segment.G);
            case 5 -> EnumSet.of(Segment.A, Segment.C, Segment.D, Segment.F, Segment.G);
            case 6 -> EnumSet.of(Segment.A, Segment.C, Segment.D, Segment.E, Segment.F, Segment.G);
            case 7 -> EnumSet.of(Segment.A, Segment.B, Segment.C, Segment.F);
            case 8 -> EnumSet.allOf(Segment.class);
            case 9 -> EnumSet.of(Segment.A, Segment.B, Segment.C, Segment.D, Segment.F, Segment.G);
            default -> EnumSet.noneOf(Segment.class);
        };
    }

    public boolean get(Segment seg) {
        return segments.contains(seg);
    }

    public void set(Segment seg, boolean on) {
        if (on) {
            segments.add(seg);
        } else {
            segments.remove(seg);
        }
    }

    public String[] getDisplayStrings() {
        String[] displayStrings = new String[5];

        displayStrings[0] = get(Segment.A) ? " ━━ " : "    ";

        displayStrings[1] = get(Segment.F) ? "┃" : " ";
        displayStrings[1] += "  ";
        displayStrings[1] += get(Segment.B) ? "┃" : " ";

        displayStrings[2] = get(Segment.G) ? " ━━ " : "    ";

        displayStrings[3] = get(Segment.E) ? "┃" : " ";
        displayStrings[3] += "  ";
        displayStrings[3] += get(Segment.C) ? "┃" : " ";

        displayStrings[4] = get(Segment.D) ? " ━━ " : "    ";

        return displayStrings;
    }
}
