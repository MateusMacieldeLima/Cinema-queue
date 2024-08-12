public class CinemaQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int size;

    // Construtor para inicializar a fila com um tamanho fixo
    public CinemaQueue(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Adiciona um novo filme na fila
    public void enqueue(String movie) throws Exception {
        if (size == queue.length) {
            throw new Exception("A fila está cheia. O filme mais antigo será removido.");
        } 
        queue[rear] = movie;
        rear = (rear + 1) % queue.length;
        size++;
    }

    // Remove o filme mais antigo da fila
    public String dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia. Nenhum filme para remover.");
        }
        String movie = queue[front];
        queue[front] = null;  // Opcional: limpa a posição
        front = (front + 1) % queue.length;
        size--;
        return movie;
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Imprime todos os filmes na fila
    public void printQueue() {
        System.out.print("Filmes na fila: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            CinemaQueue cinemaQueue = new CinemaQueue(5);

            // Adicionando filmes na fila
            cinemaQueue.enqueue("Filme A");
            cinemaQueue.enqueue("Filme B");
            cinemaQueue.enqueue("Filme C");
            cinemaQueue.enqueue("Filme D");

            // Exibindo a fila
            cinemaQueue.printQueue();

            // Removendo o filme mais antigo
            cinemaQueue.dequeue();
            cinemaQueue.printQueue();

            // Adicionando um novo filme
            cinemaQueue.enqueue("Filme E");
            cinemaQueue.printQueue();

            // Adicionando mais um filme, estourando a capacidade
            cinemaQueue.enqueue("Filme F");
            cinemaQueue.printQueue();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
