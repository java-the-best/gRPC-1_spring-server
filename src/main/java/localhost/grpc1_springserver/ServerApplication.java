package localhost.grpc1_springserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import localhost.grpc1_springserver.grpc.GrpcService;

import java.io.IOException;

public class ServerApplication {

	public static void main(String[] args)
			throws IOException, InterruptedException {

		Server server = ServerBuilder.forPort(9000)
				.addService(new GrpcService()).build();
		server.start();
		server.awaitTermination();
	}
}
