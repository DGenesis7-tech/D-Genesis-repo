import { describe, it, expect} from "vitest";
import { renderHook } from "@testing-library/react";
import useRegistry from "../customHookers/useRegistry.jsx";

describe('useRegistry Hook', () => {
    it('should return firstName and a successfull message', () => {
        const userDetails = {
            firstName: "Daniel",
            lastName: "Genesis",
            email: "example@gmail.com",
            password: "password123"
        };
        const { result } = renderHook(()=> useRegistry(userDetails));
        expect(result.current.name).toBe("Daniel");
        expect(result.current.message).toMatch("Registration Successful");
    })
})