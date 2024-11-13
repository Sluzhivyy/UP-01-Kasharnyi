import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TheaterDatabaseGUI extends JFrame {

    private JTable theaterTable;
    private JTable playTable;
    private JTable actorTable;
    private JTable performanceTable;
    private JTable ticketTable;
    private JTable viewerTable;
    private JTable viewerTicketTable;
    private JTable reviewTable;

    private DefaultTableModel theaterTableModel;
    private DefaultTableModel playTableModel;
    private DefaultTableModel actorTableModel;
    private DefaultTableModel performanceTableModel;
    private DefaultTableModel ticketTableModel;
    private DefaultTableModel viewerTableModel;
    private DefaultTableModel viewerTicketTableModel;
    private DefaultTableModel reviewTableModel;

    private Connection connection;

    public TheaterDatabaseGUI() {
        super("Театральная база данных");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Создаем таблицы
        theaterTable = new JTable();
        playTable = new JTable();
        actorTable = new JTable();
        performanceTable = new JTable();
        ticketTable = new JTable();
        viewerTable = new JTable();
        viewerTicketTable = new JTable();
        reviewTable = new JTable();

        // Создаем модели таблиц
        theaterTableModel = new DefaultTableModel();
        playTableModel = new DefaultTableModel();
        actorTableModel = new DefaultTableModel();
        performanceTableModel = new DefaultTableModel();
        ticketTableModel = new DefaultTableModel();
        viewerTableModel = new DefaultTableModel();
        viewerTicketTableModel = new DefaultTableModel();
        reviewTableModel = new DefaultTableModel();

        // Устанавливаем модели для таблиц
        theaterTable.setModel(theaterTableModel);
        playTable.setModel(playTableModel);
        actorTable.setModel(actorTableModel);
        performanceTable.setModel(performanceTableModel);
        ticketTable.setModel(ticketTableModel);
        viewerTable.setModel(viewerTableModel);
        viewerTicketTable.setModel(viewerTicketTableModel);
        reviewTable.setModel(reviewTableModel);

        // Создаем вкладки
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Театры", new JScrollPane(theaterTable));
        tabbedPane.addTab("Спектакли", new JScrollPane(playTable));
        tabbedPane.addTab("Актеры", new JScrollPane(actorTable));
        tabbedPane.addTab("Постановки", new JScrollPane(performanceTable));
        tabbedPane.addTab("Билеты", new JScrollPane(ticketTable));
        tabbedPane.addTab("Зрители", new JScrollPane(viewerTable));
        tabbedPane.addTab("Зрители-Билеты", new JScrollPane(viewerTicketTable));
        tabbedPane.addTab("Отзывы", new JScrollPane(reviewTable));

        // Создаем кнопку "Обновить"
        JButton updateButton = new JButton("Обновить");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTables();
            }
        });

        // Добавляем кнопку в панель инструментов
        JToolBar toolBar = new JToolBar();
        toolBar.add(updateButton);

        // Добавляем вкладки и кнопку в фрейм
        getContentPane().add(toolBar, BorderLayout.NORTH);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        // Устанавливаем соединение с базой данных
        connectToDatabase();

        // Заполняем таблицы
        updateTables();

        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/theatre", "root", "3318493145Lol");
            System.out.println("Соединение с базой данных установлено.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ошибка при подключении к базе данных: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTables() {
        try {
            // Обновляем данные в таблице "Театры"
            updateTheaterTable();

            // Обновляем данные в таблице "Спектакли"
            updatePlayTable();

            // Обновляем данные в таблице "Актеры"
            updateActorTable();

            // Обновляем данные в таблице "Постановки"
            updatePerformanceTable();

            // Обновляем данные в таблице "Билеты"
            updateTicketTable();

            // Обновляем данные в таблице "Зрители"
            updateViewerTable();

            // Обновляем данные в таблице "Зрители-Билеты"
            updateViewerTicketTable();

            // Обновляем данные в таблице "Отзывы"
            updateReviewTable();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ошибка при обновлении данных: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Методы для обновления таблиц
    private void updateTheaterTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Театр");
        theaterTableModel.setDataVector(getResultSetData(rs), new String[]{"ТеатрID", "Название", "Адрес", "КонтактнаяИнформация"});
        rs.close();
        stmt.close();
    }

    private void updatePlayTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Спектакль");
        playTableModel.setDataVector(getResultSetData(rs), new String[]{"СпектакльID", "Название", "Описание", "Жанр", "ТеатрID"});
        rs.close();
        stmt.close();
    }

    private void updateActorTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Актер");
        actorTableModel.setDataVector(getResultSetData(rs), new String[]{"АктерID", "Имя", "Фамилия", "Фото", "Биография"});
        rs.close();
        stmt.close();
    }

    private void updatePerformanceTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Постановка");
        performanceTableModel.setDataVector(getResultSetData(rs), new String[]{"ПостановкаID", "Название", "Режиссер", "ДатаПремьеры", "СпектакльID"});
        rs.close();
        stmt.close();
    }

    private void updateTicketTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Билет");
        ticketTableModel.setDataVector(getResultSetData(rs), new String[]{"БилетID", "ПостановкаID", "Цена"});
        rs.close();
        stmt.close();
    }

    private void updateViewerTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Зритель");
        viewerTableModel.setDataVector(getResultSetData(rs), new String[]{"ЗрительID", "Имя", "Фамилия", "Телефон", "Email", "ДатаРождения"});
        rs.close();
        stmt.close();
    }

    private void updateViewerTicketTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Зритель_Билет");
        viewerTicketTableModel.setDataVector(getResultSetData(rs), new String[]{"ЗрительID", "БилетID"});
        rs.close();
        stmt.close();
    }

    private void updateReviewTable() throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Отзыв");
        reviewTableModel.setDataVector(getResultSetData(rs), new String[]{"ОтзывID", "Текст", "Дата", "ЗрительID", "ПостановкаID"});
        rs.close();
        stmt.close();
    }

    private Object[][] getResultSetData(ResultSet rs) throws SQLException {
        // Получаем количество столбцов
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Получаем количество строк
        rs.last();
        int rowCount = rs.getRow();
        rs.beforeFirst();

        // Создаем двумерный массив для хранения данных
        Object[][] data = new Object[rowCount][columnCount];

        // Заполняем массив данными
        int row = 0;
        while (rs.next()) {
            for (int col = 0; col < columnCount; col++) {
                data[row][col] = rs.getObject(col + 1);
            }
            row++;
        }
        return data;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TheaterDatabaseGUI();
            }
        });
    }
}
