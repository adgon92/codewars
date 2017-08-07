package J001checkingGroups;

import lombok.Value;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

class Groups {

    private static final List<Group> KNOWN_GROUPS = new ArrayList<>(3);

    private static final Map<Character, Group> STARTING_CHARACTERS;
    private static final Map<Character, Group> ENDING_CHARACTERS;

    static {
        KNOWN_GROUPS.add(new Group('[', ']'));
        KNOWN_GROUPS.add(new Group('(', ')'));
        KNOWN_GROUPS.add(new Group('{', '}'));

        STARTING_CHARACTERS = KNOWN_GROUPS.stream()
                .collect(toMap(
                        Group::getStart,
                        Function.identity()
                ));

        ENDING_CHARACTERS = KNOWN_GROUPS.stream()
                .collect(toMap(
                        Group::getEnd,
                        Function.identity()
                ));
    }

    boolean groupCheck(String stringToValidate) {
        Deque<Group> openedGroups = new ArrayDeque<>();

        for (char ch : stringToValidate.toCharArray()) {
            if (isStaringCharacter(ch)) {
                openedGroups.push(STARTING_CHARACTERS.get(ch));
            } else if (ENDING_CHARACTERS.containsKey(ch)) {
                try {
                    Group lastMatchingGroup = openedGroups.pop();
                    if (lastMatchingGroup.end != ch) {
                        return false;
                    }
                } catch (NoSuchElementException ignored) {
                    return false;
                }
            }
        }

        return openedGroups.isEmpty();
    }

    private boolean isStaringCharacter(char ch) {
        return STARTING_CHARACTERS.containsKey(ch);
    }

    @Value
    private static class Group {

        char start;
        char end;

    }

}
