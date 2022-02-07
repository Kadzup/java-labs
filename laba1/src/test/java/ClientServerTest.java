import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

class ClientServerTest{
    @Test
    public void clientServer() throws IOException {
        Client client = new Client();

        client.startConnection("127.0.0.1", 6666);

        String response = client.sendMessage("invalid input");
        assertEquals("Invalid input", response);

        response = client.sendMessage("1234567890");
        assertEquals("13456789", response);
    }
}
