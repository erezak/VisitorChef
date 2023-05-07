import java.util.Stack;

// Originator
class TextEditor {
    private StringBuilder content;

    public TextEditor() {
        content = new StringBuilder();
    }

    public void write(String text) {
        content.append(text);
    }

    public String getContent() {
        return content.toString();
    }

    public void restoreFromMemento(TextEditorMemento memento) {
        content = new StringBuilder(memento.getSavedContent());
    }

    public TextEditorMemento saveToMemento() {
        return new TextEditorMemento(content.toString());
    }
}

// Memento
class TextEditorMemento {
    private String savedContent;

    public TextEditorMemento(String content) {
        savedContent = content;
    }

    public String getSavedContent() {
        return savedContent;
    }
}

// Caretaker
class TextEditorHistory {
    private Stack<TextEditorMemento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.saveToMemento());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            TextEditorMemento memento = history.pop();
            editor.restoreFromMemento(memento);
        }
    }
}

public class MementoExample {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        editor.write("Lorem ipsum dolor sit amet, ");
        history.save(editor);

        editor.write("consectetur adipiscing elit, ");
        editor.write("sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println(editor.getContent());

        editor.write(" Ut enim ad minim veniam, ");
        history.save(editor);

        editor.write("quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        System.out.println(editor.getContent());

        history.undo(editor);
        System.out.println(editor.getContent());

        history.undo(editor);
        System.out.println(editor.getContent());
    }
}
