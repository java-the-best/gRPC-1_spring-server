package localhost.grpc1_springserver.grpc;

import io.grpc.stub.StreamObserver;
import proto.GrpcRequest;
import proto.GrpcResponse;
import proto.ServiceGrpc;

public class GrpcService extends ServiceGrpc.ServiceImplBase {

    @Override
    public void grpc(GrpcRequest request,
                     StreamObserver<GrpcResponse> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        GrpcResponse response = GrpcResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
